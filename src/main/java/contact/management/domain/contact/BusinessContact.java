package main.java.contact.management.domain.contact;

public class BusinessContact extends Contact {
    private String company;

    public BusinessContact(
            String name,
            String phoneNumber,
            String company
    ) {
        super(name, phoneNumber);
        this.company = company;
    }
}
