package main.java.contact.management.domain.contact;

public class PersonalContact extends Contact  {
    private String relationship;

    public PersonalContact(
            String name,
            String phoneNumber,
            String relationship
    ) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }
}
