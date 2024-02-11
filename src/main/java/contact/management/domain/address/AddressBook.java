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

    public void addContacts(List<Contact> contacts) {
        this.contacts.addAll(contacts);
    }

    public String displayContacts(List<Contact> contacts) {
        StringBuilder message = new StringBuilder();
        for (Contact contact : contacts) {
            message.append(contact).append("\n");
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
}
