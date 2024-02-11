package main.java.contact.management.utils;

import java.util.Scanner;

public class Console  implements AutoCloseable {
    private static Scanner scanner;

    public static String readLine() {
        return getInstance().nextLine().trim();
    }

    @Override
    public void close() throws Exception {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
