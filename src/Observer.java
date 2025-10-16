import java.util.List;
import java.util.Random;

public class Observer implements Runnable {
    private Bank bank;
    private volatile boolean observing;
    private Random random = new Random();
    private static final double STORAGE_CASH = 1000000; // Деньги в хранилище

    public Observer(Bank bank) {
        this.bank = bank;
        this.observing = true;
    }

    @Override
    public void run() {
        System.out.println("Наблюдатель начал работу");

        while (observing) {
            try {
                // Проверяем каждые 3 секунды
                Thread.sleep(3000);

                System.out.println("\nНАБЛЮДАТЕЛЬ ПРОВЕРЯЕТ КАССЫ");

                List<Cashier> cashiers = bank.getCashiers();
                for (Cashier cashier : cashiers) {
                    CashRegister register = cashier.getCashRegister();
                    double cash = register.getCashAmount();

                    System.out.println("Касса " + cashier.getName() + ": " + cash + "₽");

                    // Если денег мало - пополняем из хранилища
                    if (cash < register.getMinCashLimit()) {
                        double toAdd = register.getMaxCashLimit() - cash;
                        register.depositCash(toAdd);
                        System.out.println("Пополняю кассу " + cashier.getName() + " на " + toAdd + "₽ из хранилища");
                    }
                    // Если денег много - забираем в хранилище
                    else if (cash > register.getMaxCashLimit()) {
                        double toRemove = cash - (register.getMaxCashLimit() + register.getMinCashLimit()) / 2;
                        register.withdrawCash(toRemove);
                        System.out.println("Забираю из кассы " + cashier.getName() + " " + toRemove + "₽ в хранилище");
                    }
                }
                System.out.println("ПРОВЕРКА ЗАВЕРШЕНА\n");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Наблюдатель завершил работу");
    }

    public void stopObserving() {
        this.observing = false;
    }
}