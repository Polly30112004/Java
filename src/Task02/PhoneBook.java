package Task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements IPhoneBook {
    private static final String DATA_FILE = "phonebook.dat";
    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public boolean addContact(Contact contact) {
        if (contact == null) return false;

        // Проверка на дубликаты номеров телефонов
        for (PhoneNumber phone : contact.getPhoneNumbers()) {
            if (findContactByPhoneNumber(phone.getNumber()) != null) {
                return false;
            }
        }

        contacts.add(contact);
        saveToFile();
        return true;
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public List<Contact> findContactsByName(String name) {
        List<Contact> result = new ArrayList<>();
        String searchName = name.toLowerCase();

        for (Contact contact : contacts) {
            if (contact.getFullName().toLowerCase().contains(searchName) ||
                    (contact.getNickname() != null &&
                            contact.getNickname().toLowerCase().contains(searchName))) {
                result.add(contact);
            }
        }
        return result;
    }

    @Override
    public Contact findContactByPhoneNumber(String phoneNumber) {
        String normalized = phoneNumber.replaceAll("[\\s\\-+\\(\\)]", "");

        for (Contact contact : contacts) {
            if (contact.hasPhoneNumber(normalized)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения телефонной книги: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки телефонной книги: " + e.getMessage());
        }
    }
}