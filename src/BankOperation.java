public enum BankOperation {
    DEPOSIT("Пополнение"),
    WITHDRAW("Снятие"),
    TRANSFER("Перевод"),
    PAYMENT("Оплата"),
    EXCHANGE("Обмен валюты");

    private final String description;

    BankOperation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}