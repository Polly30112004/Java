package Task02;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    public enum PhoneType {
        MOBILE("Мобильный"),
        HOME("Домашний"),
        WORK("Рабочий"),
        FAX("Факс");

        private final String description;

        PhoneType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private String number;
    private PhoneType type;

    public PhoneNumber(String number, PhoneType type) {
        if (!isValidPhoneNumber(number)) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
        this.number = normalizePhoneNumber(number);
        this.type = type;
    }

    public String getNumber() { return number; }
    public PhoneType getType() { return type; }

    private boolean isValidPhoneNumber(String number) {
        if (number == null) return false;
        return number.matches("[\\d\\s\\-+\\(\\)]+");
    }

    private String normalizePhoneNumber(String number) {
        return number.replaceAll("[\\s\\-+\\(\\)]", "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhoneNumber that = (PhoneNumber) obj;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return type.getDescription() + ": " + number;
    }
}
