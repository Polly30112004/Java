package Task02;

import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {
    private Scanner scanner;
    private IPhoneBook phoneBook;

    public PhoneBookApp() {
        this.scanner = new Scanner(System.in);
        this.phoneBook = new PhoneBook();
    }

    public void run() {
        System.out.println("=== ТЕЛЕФОННАЯ КНИГА ===");

        while (true) {
            showMenu();

            int choice = getChoice();
            if (choice == 0) break;

            processChoice(choice);
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1 - Создать новый контакт");
        System.out.println("2 - Просмотреть все контакты");
        System.out.println("3 - Поиск контакта по имени");
        System.out.println("4 - Поиск контакта по номеру телефона");
        System.out.println("0 - Выход");
        System.out.print("Ваш выбор: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1 -> createContact();
            case 2 -> viewAllContacts();
            case 3 -> searchByName();
            case 4 -> searchByPhone();
            default -> System.out.println("Неверный выбор!");
        }
    }

    private void createContact() {
        try {
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Введите фамилию (необязательно): ");
            String lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) lastName = null;

            System.out.print("Введите прозвище (необязательно): ");
            String nickname = scanner.nextLine().trim();
            if (nickname.isEmpty()) nickname = null;

            Contact contact = new Contact(firstName, lastName);
            if (nickname != null) {
                contact.setNickname(nickname);
            }

            addPhoneNumbers(contact);
            addEmails(contact);
            addBirthYear(contact);

            if (phoneBook.addContact(contact)) {
                System.out.println("\nКонтакт успешно создан!");
                System.out.println(contact.getDetailedInfo());
            } else {
                System.out.println("Ошибка: контакт с такими номерами уже существует!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания контакта: " + e.getMessage());
        }
    }

    private void addPhoneNumbers(Contact contact) {
        System.out.println("\nДобавление номеров телефонов:");
        while (true) {
            System.out.println("Типы номеров: 1-Мобильный, 2-Домашний, 3-Рабочий, 4-Факс, 0-Завершить");
            System.out.print("Выберите тип: ");
            String typeChoice = scanner.nextLine();

            if (typeChoice.equals("0")) break;

            PhoneNumber.PhoneType type = getPhoneType(typeChoice);
            if (type == null) continue;

            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine().trim();

            try {
                PhoneNumber phone = new PhoneNumber(number, type);
                if (contact.addPhoneNumber(phone)) {
                    System.out.println("Номер добавлен.");
                } else {
                    System.out.println("Этот номер уже есть у контакта.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private PhoneNumber.PhoneType getPhoneType(String choice) {
        switch (choice) {
            case "1": return PhoneNumber.PhoneType.MOBILE;
            case "2": return PhoneNumber.PhoneType.HOME;
            case "3": return PhoneNumber.PhoneType.WORK;
            case "4": return PhoneNumber.PhoneType.FAX;
            default:
                System.out.println("Неверный тип!");
                return null;
        }
    }

    private void addEmails(Contact contact) {
        System.out.println("\nДобавление email (необязательно):");
        while (true) {
            System.out.print("Введите email (или Enter для пропуска): ");
            String email = scanner.nextLine().trim();

            if (email.isEmpty()) break;

            if (contact.addEmail(email)) {
                System.out.println("Email добавлен.");
            } else {
                System.out.println("Неверный формат email или он уже существует.");
            }

            System.out.print("Добавить еще email? (y/n): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private void addBirthYear(Contact contact) {
        System.out.print("Введите год рождения (необязательно): ");
        String yearInput = scanner.nextLine().trim();
        if (!yearInput.isEmpty()) {
            try {
                int year = Integer.parseInt(yearInput);
                contact.setBirthYear(year);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат года.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private void viewAllContacts() {
        List<Contact> contacts = phoneBook.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("Телефонная книга пуста.");
            return;
        }

        System.out.println("\n=== ВСЕ КОНТАКТЫ ===");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private void searchByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine().trim();

        List<Contact> results = phoneBook.findContactsByName(name);

        if (results.isEmpty()) {
            System.out.println("Контакты не найдены.");
            return;
        }

        System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i).getDetailedInfo());
        }
    }

    private void searchByPhone() {
        System.out.print("Введите номер телефона для поиска: ");
        String phone = scanner.nextLine().trim();

        Contact contact = phoneBook.findContactByPhoneNumber(phone);

        if (contact == null) {
            System.out.println("Контакт не найден.");
            return;
        }

        System.out.println("\n=== НАЙДЕННЫЙ КОНТАКТ ===");
        System.out.println(contact.getDetailedInfo());
    }
}
