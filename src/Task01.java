public class Task01 {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // ЗАПУСКАЕМ РАБОЧИЙ ДЕНЬ В БАНКЕ
        bank.startBankDay();

        // Ждем некоторое время пока банк работает
        try {
            Thread.sleep(15000); // Банк работает 30 секунд
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // ЗАКРЫВАЕМ БАНК
        bank.endBankDay();
    }
}