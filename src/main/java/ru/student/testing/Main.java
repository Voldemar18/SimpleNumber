package ru.student.testing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleReader consoleReader = new ConsoleReader(scanner);
        Menu menu = new Menu(consoleReader);
        menu.start();
        scanner.close();
    }
}