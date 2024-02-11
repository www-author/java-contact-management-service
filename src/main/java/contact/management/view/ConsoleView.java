package main.java.contact.management.view;

import main.java.contact.management.utils.Console;

import static main.java.contact.management.constants.Message.*;

public class ConsoleView {
    public String readSelectedMenuNumber() {
        System.out.print(CONTACT_MENU_SELECT.getMessage());
        return Console.readLine();
    }

    public String readUserName() {
        System.out.print(INPUT_NAME.getMessage());
        return Console.readLine();
    }

    public String readContact() {
        System.out.print(INPUT_CONTACT.getMessage());
        return Console.readLine();
    }

    public String readCompany() {
        System.out.print(INPUT_COMPANY_NAME.getMessage());
        return Console.readLine();
    }

    public String readRelationship() {
        System.out.print(INPUT_RELATIONSHIP.getMessage());
        return Console.readLine();
    }

    public String searchContact() {
        System.out.print(INPUT_NAME_TO_SEARCH.getMessage());
        return Console.readLine();
    }

    public void printMenuResult(String message) {
        System.out.println(message);
    }
}
