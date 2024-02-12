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
import java.util.List;

import static main.java.contact.management.constants.Menu.convertToMenu;


public class ContactManagementController {
    private final ConsoleView view;

    public ContactManagementController() {
        this.view = new ConsoleView();
    }

    public void run() {
        try (Console console = new Console()) {
            Menu menu = convertToMenu(view.readSelectedMenuNumber());
            AddressBook addressBook = AddressBook.from(new ArrayList<>());
            distributeMenu(menu, addressBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void distributeMenu(Menu menu, AddressBook addressBook) {
        while (true) {
            switch (menu) {
                case BUSINESS_CONTACT_ADDITION -> addBusinessContact(addressBook);
                case PERSONAL_CONTACT_ADDITION -> addPersonalContact(addressBook);
                case CONTACT_OUTPUT -> displayContacts(addressBook);
                case CONTACT_SEARCH -> searchContact(addressBook);
                case EXIT -> {
                    view.printMenuResult(Message.EXIT_THE_PROGRAM.getMessage());
                    return;
                }
                default -> view.printMenuResult(menu.getMessage());
            }
            menu = convertToMenu(view.readSelectedMenuNumber());
        }
    }

    /*TODO (refactor) 서비스 단으로 메서드 분리*/
    private void addBusinessContact(AddressBook addressBook) {
        // TODO 입력 값들  빈값 유효성 검사
        // TODO 연락처 유효성 검사
        String name = view.readUserName();
        String contact = view.readContact();
        String company = view.readCompany();
        BusinessContact businessContact = BusinessContact.of(name, contact, company);
        addressBook.addContacts(List.of(businessContact));
    }

    private void addPersonalContact(AddressBook addressBook) {
        // TODO 입력 값들  빈값 유효성 검사
        // TODO 연락처 유효성 검사
        String name = view.readUserName();
        String contact = view.readContact();
        String relationship = view.readRelationship();
        PersonalContact personalContact = PersonalContact.of(name, contact, relationship);
        addressBook.addContacts(List.of(personalContact));
    }

    private void displayContacts(AddressBook addressBook) {
        String message = addressBook.displayContacts(addressBook.getContacts());
        if(message.isEmpty()){
            message = ExceptionMessage.EMPTY_CONTACT.getMessage();
        }
        view.printMenuResult(message);
    }

    private void searchContact(AddressBook addressBook) {
        String searchName = view.searchContact();
        String message = addressBook.searchContact(searchName);
        view.printMenuResult(message);
    }
}
