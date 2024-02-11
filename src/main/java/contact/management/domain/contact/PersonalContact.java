package main.java.contact.management.domain.contact;

public class PersonalContact extends Contact  {
    private final String relationship;

    private PersonalContact(
            String name,
            String phoneNumber,
            String relationship
    ) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    public static PersonalContact of(
            String name,
            String phoneNumber,
            String relationship
    ) {
        return new PersonalContact(name, phoneNumber, relationship);
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "이름: " + getName() + ", 전화번호: " + getPhoneNumber() + ", 관계: " + getRelationship();
    }
}
