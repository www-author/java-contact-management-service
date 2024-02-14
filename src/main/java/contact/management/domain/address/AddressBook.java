package main.java.contact.management.domain.address;

import main.java.contact.management.constants.ExceptionMessage;
import main.java.contact.management.domain.contact.Contact;

import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    private AddressBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static AddressBook from(List<Contact> contacts) {
        return new AddressBook(contacts);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public String displayContacts(List<Contact> contacts) {
        StringBuilder message = new StringBuilder();
        for (Contact contact : contacts) {
            message.append(contact).append("\n");
        }
        // 연락처 정보가 없는 경우 예외 발생
        if(message.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_CONTACT.getMessage());
        }
        return String.valueOf(message);
    }

    public String searchContact(String name) {
        StringBuilder message = new StringBuilder();
        for (Contact contact : contacts) {
            if(name.equals(contact.getName())) {
                message.append("\n").append(contact);
            }
        }

        if(name.isEmpty() || message.isEmpty()) {
            return ExceptionMessage.NOT_FOUND_CONTACT.getMessage();
        }
        return String.valueOf(message);
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
