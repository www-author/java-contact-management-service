package main.java.contact.management.utils;

import java.util.List;
import static main.java.contact.management.constants.ExceptionMessage.*;

public class NumberValidator {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void validateBlankMenu(String number) {
        if (number.isBlank()) {
            setMessage(BLANK_MENU_NUMBER.getMessage());
        }
    }

    public void validateBlankInputValues(List<String> inputs) {
        for (String input : inputs) {
            if (input.isEmpty()) {
                setMessage(EMPTY_VALUE.getMessage());
                return;
            }
        }
    }

    public void validateMenuNumber(String number) {
        String regex = "[1-5]";
        if (!number.matches(regex)) {
            setMessage(INVALID_MENU_NUMBER.getMessage());
        }
    }

    public void validatePhoneNumber(String number) {
        String regex = "^(\\d{3}-?\\d{3}-?\\d{4})$";
        if (!number.matches(regex)) {
            setMessage(INVALID_CONTACT_FORMAT.getMessage());
        }
    }
}