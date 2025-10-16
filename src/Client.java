import java.util.Random;

public class Client implements Runnable {
    private String name;
    private Bank bank;
    private Account account;
    private BankOperation operation;
    private double amount;
    private Random random = new Random();

    public Client(String name, Bank bank, Account account) {
        this.name = name;
        this.bank = bank;
        this.account = account;
        // Случайная операция для клиента
        this.operation = BankOperation.values()[random.nextInt(BankOperation.values().length)];
        this.amount = random.nextInt(1000) + 100; // Сумма от 100 до 1100
    }

    @Override
    public void run() {
        System.out.println(name + " [" + java.time.LocalTime.now() + "]: Пришел в банк для операции " + operation.getDescription());

        try {
            // Клиент "думает" перед тем как подойти к кассе
            Thread.sleep(random.nextInt(2000));

            // Выбираем случайного кассира и встаем в очередь
            Cashier cashier = bank.getRandomCashier();
            cashier.addClient(this);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public BankOperation getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }
}