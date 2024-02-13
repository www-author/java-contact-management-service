package main.java.contact.management.controller;

import main.java.contact.management.constants.ExceptionMessage;
import main.java.contact.management.constants.Menu;
import main.java.contact.management.constants.Message;
import main.java.contact.management.domain.address.AddressBook;
import main.java.contact.management.domain.contact.BusinessContact;
import main.java.contact.management.domain.contact.PersonalContact;
import main.java.contact.management.utils.Console;
import main.java.contact.management.view.ConsoleView;

import java.util.ArrayList;

import static main.java.contact.management.constants.Menu.convertToMenu;


public class ContactManagementController {
    private final ConsoleView view;
    // 별도의 service 계층 대신 해당 클래스에서 처리
    private final AddressBook addressBook;

    public ContactManagementController() {
        this.view = new ConsoleView();
        this.addressBook = AddressBook.from(new ArrayList<>());
    }

    public void run() {
        try (Console console = new Console()) {
            Menu menu = convertToMenu(view.readSelectedMenuNumber());
            distributeMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void distributeMenu(Menu menu) {
        while (true) {
            switch (menu) {
                case BUSINESS_CONTACT_ADDITION -> view.printMenuResult(addBusinessContact());
                case PERSONAL_CONTACT_ADDITION -> view.printMenuResult(addPersonalContact());
                case CONTACT_OUTPUT -> view.printMenuResult(displayContact());
                case CONTACT_SEARCH -> view.printMenuResult(searchContact());
                case EXIT -> {
                    view.printMenuResult(Message.EXIT_THE_PROGRAM.getMessage());
                    return;
                }
                default -> view.printMenuResult(menu.getMessage());
            }
            menu = convertToMenu(view.readSelectedMenuNumber());
        }
    }

    private String addBusinessContact() {
        // TODO 입력 값들  빈값 유효성 검사
        // TODO 연락처 유효성 검사
        String name = view.readUserName();
        String contact = view.readContact();
        String company = view.readCompany();
        addressBook.addContact(BusinessContact.of(name, contact, company));
        return Message.CONTACT_ADDITION.getMessage();
    }

    private String addPersonalContact() {
        // TODO 입력 값들  빈값 유효성 검사
        // TODO 연락처 유효성 검사
        String name = view.readUserName();
        String contact = view.readContact();
        String relationship = view.readRelationship();
        addressBook.addContact(PersonalContact.of(name, contact, relationship));
        return Message.CONTACT_ADDITION.getMessage();
    }

    private String displayContact() {
        String message = addressBook.displayContacts(addressBook.getContacts());
        if(message.isEmpty()){
            message = ExceptionMessage.EMPTY_CONTACT.getMessage();
        }
        return message;
    }

    private String searchContact() {
        String searchName = view.searchContact();
        return addressBook.searchContact(searchName);
    }
}
