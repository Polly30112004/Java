public class Money {
    private long rubles;
    private byte kopecks;

    // Конструкторы
    public Money() {
        this.rubles = 0;
        this.kopecks = 0;
    }

    public Money(long rubles, byte kopecks) {
        setMoney(rubles, kopecks);
    }

    public Money(double amount) {
        setMoney(amount);
    }

    // Приватный конструктор для внутреннего использования
    private Money(long rubles, int kopecks) {
        this.rubles = rubles;
        this.kopecks = (byte) kopecks;
        normalize();
    }

    // Геттеры и сеттеры с валидацией
    public long getRubles() {
        return rubles;
    }

    public void setRubles(long rubles) {
        if (rubles < 0) {
            throw new IllegalArgumentException("Рубли не могут быть отрицательными");
        }
        this.rubles = rubles;
    }

    public byte getKopecks() {
        return kopecks;
    }

    public void setKopecks(byte kopecks) {
        if (kopecks < 0 || kopecks >= 100) {
            throw new IllegalArgumentException("Копейки должны быть в диапазоне 0-99");
        }
        this.kopecks = kopecks;
    }

    public void setMoney(long rubles, byte kopecks) {
        setRubles(rubles);
        setKopecks(kopecks);
    }

    public void setMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        this.rubles = (long) amount;
        double fractional = amount - this.rubles;
        this.kopecks = (byte) Math.round(fractional * 100);
        normalize();
    }

    // Нормализация (если копеек >= 100 или < 0)
    private void normalize() {
        if (kopecks >= 100) {
            rubles += kopecks / 100;
            kopecks = (byte) (kopecks % 100);
        } else if (kopecks < 0) {
            rubles -= 1;
            kopecks += 100;
        }
    }

    // Операции сложения
    public Money add(Money other) {
        long totalRubles = this.rubles + other.rubles;
        int totalKopecks = this.kopecks + other.kopecks;
        return new Money(totalRubles, totalKopecks);
    }

    // Операции вычитания
    public Money subtract(Money other) {
        long totalRubles = this.rubles - other.rubles;
        int totalKopecks = this.kopecks - other.kopecks;

        Money result = new Money(totalRubles, totalKopecks);
        if (result.rubles < 0) {
            throw new IllegalArgumentException("Результат вычитания не может быть отрицательным");
        }

        return result;
    }

    // Деление сумм
    public double divide(Money other) {
        if (other.rubles == 0 && other.kopecks == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }
        double thisAmount = this.rubles + this.kopecks / 100.0;
        double otherAmount = other.rubles + other.kopecks / 100.0;
        return thisAmount / otherAmount;
    }

    // Деление суммы на дробное число
    public Money divide(double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }
        double amount = (this.rubles + this.kopecks / 100.0) / divisor;
        return new Money(amount);
    }

    // Умножение на дробное число
    public Money multiply(double multiplier) {
        double amount = (this.rubles + this.kopecks / 100.0) * multiplier;
        return new Money(amount);
    }

    // Операции сравнения
    public boolean equals(Money other) {
        return this.rubles == other.rubles && this.kopecks == other.kopecks;
    }

    public boolean greaterThan(Money other) {
        if (this.rubles > other.rubles) return true;
        if (this.rubles == other.rubles && this.kopecks > other.kopecks) return true;
        return false;
    }

    public boolean lessThan(Money other) {
        if (this.rubles < other.rubles) return true;
        if (this.rubles == other.rubles && this.kopecks < other.kopecks) return true;
        return false;
    }

    // Вывод значения
    @Override
    public String toString() {
        return String.format("%d,%02d", rubles, kopecks);
    }
}