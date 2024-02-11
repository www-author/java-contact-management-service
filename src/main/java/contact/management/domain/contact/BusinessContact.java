package main.java.contact.management.domain.contact;

public class BusinessContact extends Contact {
    private final String company;

    private BusinessContact(
            String name,
            String phoneNumber,
            String company
    ) {
        super(name, phoneNumber);
        this.company = company;
    }

    public static BusinessContact of(
            String name,
            String phoneNumber,
            String company
    ) {
        return new BusinessContact(name, phoneNumber, company);
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "이름: " + getName() + ", 전화번호: " + getPhoneNumber() + ", 회사명: " + getCompany();
    }
}
