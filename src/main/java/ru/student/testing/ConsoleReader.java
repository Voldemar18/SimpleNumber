package ru.student.testing;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public MenuOption readMenuChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                MenuOption option = MenuOption.fromCode(choice);
                if (option != null) {
                    return option;
                }
                System.out.println("ОШИБКА: Введите 1 или 2!");
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА: Введите число!");
            }
        }
    }

    public int readPositiveInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value < min) {
                    System.out.println("Ошибка: Число должно быть не меньше " + min);
                } else if (value > max) {
                    System.out.println("Ошибка: Число не больше " + max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число!");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}