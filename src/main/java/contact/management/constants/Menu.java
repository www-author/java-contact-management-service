package main.java.contact.management.constants;

import main.java.contact.management.utils.NumberValidator;

public enum Menu {
    BUSINESS_CONTACT_ADDITION(1),
    PERSONAL_CONTACT_ADDITION (2),
    CONTACT_OUTPUT(3),
    CONTACT_SEARCH(4),
    EXIT(5),
    INVALID_MENU(-1);

    private final int number;
    private String message;

    Menu(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static Menu convertToMenu(String menuNumberFormat) {
        String validationMessage = getMenuValidationMessage(menuNumberFormat);
        for (Menu menu : Menu.values()) {
            if (validationMessage == null && menu.number == Integer.parseInt(menuNumberFormat)) {
                return menu;
            }
        }
        INVALID_MENU.setMessage(validationMessage);
        return INVALID_MENU;
    }

    private static String getMenuValidationMessage(String menuNumberFormat) {
        NumberValidator numberValidator = new NumberValidator();
        numberValidator.validateMenuNumber(menuNumberFormat);
        numberValidator.validateBlankMenu(menuNumberFormat);
        return numberValidator.getMessage();
    }

}
