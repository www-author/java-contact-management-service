package main.java.contact.management;

import main.java.contact.management.controller.ContactManagementController;

public class Application {
    public static void main(String[] args) {
        ContactManagementController contactManagementController = new ContactManagementController();
        contactManagementController.run();
    }
}
