import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bank {
    private List<Cashier> cashiers;
    private List<Account> accounts;
    private Observer observer;
    private ExecutorService executor;
    private Random random = new Random();

    public Bank() {
        this.cashiers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        initializeBank();
    }

    private void initializeBank() {
        // Создаем счета
        for (int i = 1; i <= 10; i++) {
            accounts.add(new Account("ACC-" + i, random.nextInt(10000) + 5000));
        }

        // Создаем кассиров
        for (int i = 1; i <= 3; i++) {
            cashiers.add(new Cashier("Кассир-" + i, this, 100000));
        }

        // Создаем наблюдателя
        this.observer = new Observer(this);

        // Пул потоков для клиентов
        this.executor = Executors.newCachedThreadPool();
    }

    public void startBankDay() {
        System.out.println("БАНК ОТКРЫЛСЯ");

        // ЗАПУСКАЕМ КАССИРОВ (каждый в своем потоке)
        for (Cashier cashier : cashiers) {
            new Thread(cashier).start();
        }

        // ЗАПУСКАЕМ НАБЛЮДАТЕЛЯ (в своем потоке)
        new Thread(observer).start();

        // ЗАПУСКАЕМ КЛИЕНТОВ (каждый в своем потоке)
        for (int i = 1; i <= 15; i++) {
            Account randomAccount = getRandomAccount();
            Client client = new Client("Клиент-" + i, this, randomAccount);
            executor.execute(client); // Запускаем клиента в отдельном потоке

            // Клиенты приходят с задержкой
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void endBankDay() {
        System.out.println("\nБАНК ЗАКРЫВАЕТСЯ");

        // Останавливаем кассиров
        for (Cashier cashier : cashiers) {
            cashier.stopWorking();
        }

        // Останавливаем наблюдателя
        observer.stopObserving();

        // Завершаем пул потоков
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("БАНК ЗАКРЫТ");
    }

    public Cashier getRandomCashier() {
        return cashiers.get(random.nextInt(cashiers.size()));
    }

    public Account getRandomAccount() {
        return accounts.get(random.nextInt(accounts.size()));
    }

    public List<Cashier> getCashiers() {
        return new ArrayList<>(cashiers);
    }
}