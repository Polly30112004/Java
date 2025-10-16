package Task02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Contact implements Serializable {
    private String firstName;
    private String lastName;
    private String nickname;
    private List<PhoneNumber> phoneNumbers;
    private List<String> emails;
    private Integer birthYear;

    public Contact(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.firstName = firstName.trim();
        this.lastName = lastName != null ? lastName.trim() : "";
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNickname() { return nickname; }
    public List<PhoneNumber> getPhoneNumbers() { return new ArrayList<>(phoneNumbers); }
    public List<String> getEmails() { return new ArrayList<>(emails); }
    public Integer getBirthYear() { return birthYear; }

    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setBirthYear(Integer birthYear) {
        if (birthYear != null && (birthYear < 1900 || birthYear > 2100)) {
            throw new IllegalArgumentException("Неверный год рождения");
        }
        this.birthYear = birthYear;
    }

    public boolean addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber == null) return false;
        if (phoneNumbers.contains(phoneNumber)) {
            return false;
        }
        phoneNumbers.add(phoneNumber);
        return true;
    }

    public boolean addEmail(String email) {
        if (email == null || !isValidEmail(email)) {
            return false;
        }
        String normalizedEmail = email.trim().toLowerCase();
        if (!emails.contains(normalizedEmail)) {
            emails.add(normalizedEmail);
            return true;
        }
        return false;
    }

    public boolean hasPhoneNumber(String phoneNumber) {
        String normalized = phoneNumber.replaceAll("[\\s\\-+\\(\\)]", "");
        return phoneNumbers.stream()
                .anyMatch(p -> p.getNumber().equals(normalized));
    }

    public String getFullName() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFullName());

        if (nickname != null && !nickname.isEmpty()) {
            sb.append(" (").append(nickname).append(")");
        }

        if (birthYear != null) {
            sb.append(", ").append(birthYear).append(" г.р.");
        }

        return sb.toString();
    }

    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n");

        if (!phoneNumbers.isEmpty()) {
            sb.append("Телефоны:\n");
            for (PhoneNumber phone : phoneNumbers) {
                sb.append("  ").append(phone).append("\n");
            }
        }

        if (!emails.isEmpty()) {
            sb.append("Emails:\n");
            for (String email : emails) {
                sb.append("  ").append(email).append("\n");
            }
        }

        return sb.toString();
    }
}
