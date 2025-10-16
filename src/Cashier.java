import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cashier implements Runnable {
    private String name;
    private Bank bank;
    private CashRegister cashRegister;
    private BlockingQueue<Client> clientQueue; // ОЧЕРЕДЬ клиентов
    private volatile boolean working; // Флаг работы
    private Random random = new Random();

    public Cashier(String name, Bank bank, double initialCash) {
        this.name = name;
        this.bank = bank;
        this.cashRegister = new CashRegister(initialCash);
        this.clientQueue = new LinkedBlockingQueue<>();
        this.working = true;
    }

    public void addClient(Client client) {
        try {
            clientQueue.put(client); // ️ Клиент встает в очередь
            System.out.println(name + ": Клиент " + client.getName() + " встал в очередь");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        System.out.println(name + " начал работу");

        while (working || !clientQueue.isEmpty()) {
            try {
                // ОЖИДАНИЕ - поток "спит" пока нет клиентов
                // Это БЛОКИРУЮЩАЯ операция - поток ждет здесь
                Client client = clientQueue.take();

                System.out.println(name + " [" + java.time.LocalTime.now() + "]: Обслуживаю " + client.getName());

                // Обслуживаем клиента
                serveClient(client);

                // Имитируем время обслуживания
                Thread.sleep(random.nextInt(1000) + 500);

                System.out.println(name + " [" + java.time.LocalTime.now() + "]: Завершил обслуживание " + client.getName());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(name + " завершил работу");
    }

    private void serveClient(Client client) {
        BankOperation operation = client.getOperation();
        double amount = client.getAmount();

        switch (operation) {
            case DEPOSIT:
                processDeposit(client, amount);
                break;
            case WITHDRAW:
                processWithdraw(client, amount);
                break;
            case TRANSFER:
                processTransfer(client, amount);
                break;
            case PAYMENT:
                processPayment(client, amount);
                break;
            case EXCHANGE:
                processExchange(client, amount);
                break;
        }
    }

    private void processDeposit(Client client, double amount) {
        // Синхронизация через замок в Account
        client.getAccount().deposit(amount);
        cashRegister.depositCash(amount);
        System.out.println(name + ": " + client.getName() + " пополнил счет на " + amount + "₽");
    }

    private void processWithdraw(Client client, double amount) {
        // Двойная синхронизация - счет и касса
        if (cashRegister.withdrawCash(amount)) {
            if (client.getAccount().withdraw(amount)) {
                System.out.println(name + ": " + client.getName() + " снял " + amount + "₽");
            } else {
                cashRegister.depositCash(amount); // Возвращаем деньги в кассу
                System.out.println(name + ": Ошибка - недостаточно средств на счете");
            }
        } else {
            System.out.println(name + ": Ошибка - недостаточно наличных в кассе");
        }
    }

    private void processTransfer(Client client, double amount) {
        Account targetAccount = bank.getRandomAccount();
        if (Account.transfer(client.getAccount(), targetAccount, amount)) {
            System.out.println(name + ": " + client.getName() + " перевел " + amount + "₽ на счет " + targetAccount.getAccountNumber());
        } else {
            System.out.println(name + ": Ошибка перевода - недостаточно средств");
        }
    }

    private void processPayment(Client client, double amount) {
        if (client.getAccount().withdraw(amount)) {
            System.out.println(name + ": " + client.getName() + " оплатил услугу на " + amount + "₽");
        } else {
            System.out.println(name + ": Ошибка оплаты - недостаточно средств");
        }
    }

    private void processExchange(Client client, double amount) {
        // Упрощенный обмен валюты
        if (client.getAccount().withdraw(amount)) {
            double exchangedAmount = amount * 0.015; // Пример курса
            client.getAccount().deposit(exchangedAmount);
            System.out.println(name + ": " + client.getName() + " обменял " + amount + "₽ на " + exchangedAmount + "$");
        } else {
            System.out.println(name + ": Ошибка обмена - недостаточно средств");
        }
    }

    public void stopWorking() {
        this.working = false;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public String getName() {
        return name;
    }
}