package ru.student.testing;

public class Menu {
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final PrimeNumberService primeService = new PrimeNumberService();

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            MenuOption choice = consoleReader.readMenuChoice();

            switch (choice) {
                case FIND_PRIMES -> executeFindPrimes();
                case EXIT -> {
                    System.out.println("Завершение программы...");
                    running = false;
                }
            }
        }
        consoleReader.close();
    }

    private void printMenu() {
        System.out.println("\n\n--------------МЕНЮ-------------");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + " - " + option.getDescription());
        }
        System.out.print("Выберите действие: ");
    }

    private void executeFindPrimes() {
        int maxNumber = consoleReader.readPositiveInt("Введите число N (от 2 до 1000000): ", 2, 1_000_000);
        primeService.printAllNumbersUpTo(maxNumber);
        primeService.printPrimesUpTo(maxNumber);
    }
}