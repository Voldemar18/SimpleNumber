package ru.student.testing;

import java.util.Scanner;

public class Main {

    public static void SimpleNumber() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите число N (от 2 до 1000000): ");
                n = Integer.parseInt(sc.nextLine());

                if (n < 2) {
                    System.out.println("Ошибка: Число должно быть больше 1 (простые числа начинаются с 2). Попробуйте снова.");
                } else if (n > 1000000) {
                    System.out.println("Ошибка: Число слишком большое. Введите число не больше 1 000 000.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число, а не текст или символы!");
            }
        }

        System.out.print("Все числа от 1 до " + n + ": ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Простые числа от 2 до " + n + ": ");

        boolean foundPrime = false;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                if (foundPrime) {
                    System.out.print(", ");
                }
                System.out.print(i);
                foundPrime = true;
            }
        }

        if (!foundPrime) {
            System.out.print("нет простых чисел");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n\n--------------МЕНЮ-------------");
                System.out.println("1 - Найти простые числа от 1 до N");
                System.out.println("2 - Завершить программу");
                System.out.print("Выберите действие: ");

                int choice = 0;
                try {
                    choice = Integer.parseInt(mainScanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ОШИБКА: Введите число 1 или 2!");
                    continue;
                }
                System.out.println("-------------------------------\n\n");
                switch (choice) {
                    case 1:
                        SimpleNumber();
                        break;
                    case 2:
                        System.out.println("Завершение программы...");
                        running = false;
                        break;
                    default:
                        System.out.println("ОШИБКА: Некорректный выбор! Введите 1 или 2.");
                }

            } catch (Exception e) {
                System.out.println("НЕПРЕДВИДЕННАЯ ОШИБКА: " + e.getMessage());
                System.out.println("Пожалуйста, перезапустите программу.");
            }
        }

        mainScanner.close();
        System.out.println("Программа успешно завершена.");
    }
}