import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String accountNumber;
    private double balance;
    private final Lock lock; // Замок для синхронизации

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock(); // Создаем замок
    }

    //  КРИТИЧЕСКАЯ СЕКЦИЯ - только один поток может выполнять
    public boolean withdraw(double amount) {
        lock.lock(); //  ЗАКРЫВАЕМ замок - другие потоки ждут здесь
        try {
            if (balance >= amount) {
                // Имитируем время операции
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock(); //  ОТКРЫВАЕМ замок - пускаем следующий поток
        }
    }

    //  КРИТИЧЕСКАЯ СЕКЦИЯ
    public void deposit(double amount) {
        lock.lock(); //  ЖДЕМ если другой поток работает со счетом
        try {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance += amount;
        } finally {
            lock.unlock(); //  Разрешаем другим потокам работать
        }
    }

    // КРИТИЧЕСКАЯ СЕКЦИЯ для перевода
    public static boolean transfer(Account from, Account to, double amount) {
        // БЛОКИРУЕМ ОБА СЧЕТА чтобы не было "гонки"
        while (true) {
            if (from.lock.tryLock()) { // Пытаемся заблокировать первый счет
                try {
                    if (to.lock.tryLock()) { // Пытаемся заблокировать второй счет
                        try {
                            if (from.balance >= amount) {
                                from.balance -= amount;
                                to.balance += amount;
                                return true;
                            }
                            return false;
                        } finally {
                            to.lock.unlock();
                        }
                    }
                } finally {
                    from.lock.unlock();
                }
            }
            // Если не получилось заблокировать оба счета - ждем и пробуем снова
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}