package ru.student.testing;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public MenuOption readMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return MenuOption.fromCode(choice);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}