package ru.student.testing;

public class Menu {
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final PrimeNumberService primeService = new PrimeNumberService();

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = consoleReader.readMenuChoice();

            switch (choice) {
                case 1 -> executeFindPrimes();
                case 2 -> {
                    System.out.println("Завершение программы...");
                    running = false;
                }
                default -> System.out.println("ОШИБКА: Некорректный выбор! Введите 1 или 2.");
            }
        }
        consoleReader.close();
    }

    private void printMenu() {
        System.out.println("\n\n--------------МЕНЮ-------------");
        System.out.println("1 - Найти простые числа от 1 до N");
        System.out.println("2 - Завершить программу");
        System.out.print("Выберите действие: ");
    }

    private void executeFindPrimes() {
        int maxNumber = consoleReader.readPositiveInt("Введите число N (от 2 до 1000000): ", 2, 1_000_000);
        primeService.printAllNumbersUpTo(maxNumber);
        primeService.printPrimesUpTo(maxNumber);
    }
}