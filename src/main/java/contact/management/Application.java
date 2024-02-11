package main.java.contact.management;

import main.java.contact.management.controller.ContactManagementController;

public class Application {
    public static void main(String[] args) {
        ContactManagementController contactManagementController = new ContactManagementController();
        contactManagementController.run();
    }
}

/* 아래 같은 방법도 있어욤! */
// 반복문 대신에
// 이벤트 리스너 방식 ? => 각 조건에 이벤트 리스너를 달아서 하기