package Task02;

import java.util.List;

public interface IPhoneBook {
    boolean addContact(Contact contact);
    List<Contact> getAllContacts();
    List<Contact> findContactsByName(String name);
    Contact findContactByPhoneNumber(String phoneNumber);
    void saveToFile();
    void loadFromFile();
}
