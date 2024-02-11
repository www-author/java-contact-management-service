package main.java.contact.management.constants;

public enum Menu {
    BUSINESS_CONTACT_ADDITION("1"),
    PERSONAL_CONTACT_ADDITION ("2"),
    CONTACT_OUTPUT("3"),
    CONTACT_SEARCH("4"),
    EXIT("5"),
    INVALID_MENU("INVALID");

    private String number;
    Menu(String menu) {
        this.number = menu;
    }

    public String getNumber() {
        return this.number;
    }

    public static Menu searchMenu(String MenuNumberFormat) {
        for (Menu menu : Menu.values()) {
            if (menu.number.equals(MenuNumberFormat)) {
                return menu;
            }
        }
        return INVALID_MENU;
    }
}
