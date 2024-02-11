package main.java.contact.management.utils;

import static main.java.contact.management.constants.ExceptionMessage.BLANK_MENU_NUMBER;
import static main.java.contact.management.constants.ExceptionMessage.INVALID_MENU_NUMBER;

public class NumberValidator {
    private final String number;
    private String message;

    public String getNumber() {
        return this.number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private NumberValidator(String number) {
        this.number = number.trim();
        validateMenuNumber(number);
        validateBlank(number);
    }

    public static NumberValidator from(String number) {
        return new NumberValidator(number);
    }

    public void validateBlank(String number) {
        if (number.isBlank()) {
            setMessage(BLANK_MENU_NUMBER.getMessage());
        }
    }

    public void validateMenuNumber(String number) {
        String regex = "[1-5]";
        if (!number.matches(regex)) {
            setMessage(INVALID_MENU_NUMBER.getMessage());
            return;
        }
    }
}