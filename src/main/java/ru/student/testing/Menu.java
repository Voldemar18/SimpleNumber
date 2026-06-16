package ru.student.testing;

public class Menu {
    private final ConsoleReader consoleReader;
    private final PrimeNumberService primeService;

    public Menu(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
        this.primeService = new PrimeNumberService();
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            MenuOption choice = consoleReader.readMenuChoice();

            if (choice == null) {
                System.out.println("ОШИБКА: Введите одно из значений: " + MenuOption.getValidCodes());
                continue;
            }

            switch (choice) {
                case FIND_PRIMES -> executeFindPrimes();
                case EXIT -> {
                    System.out.println("Завершение программы...");
                    running = false;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("\n\n--------------МЕНЮ-------------");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + " - " + option.getDescription());
        }
        System.out.print("Выберите действие: ");
    }

    private void executeFindPrimes() {
        System.out.print("Введите число N (от 2 до 1000000): ");
        int maxNumber = consoleReader.readInt();

        while (maxNumber < 2 || maxNumber > 1_000_000) {
            if (maxNumber == Integer.MIN_VALUE) {
                System.out.println("Ошибка: Введите целое число!");
            } else if (maxNumber < 2) {
                System.out.println("Ошибка: Число должно быть не меньше 2");
            } else {
                System.out.println("Ошибка: Число не больше 1_000_000");
            }
            System.out.print("Введите число N (от 2 до 1000000): ");
            maxNumber = consoleReader.readInt();
        }

        primeService.printAllNumbersUpTo(maxNumber);
        primeService.printPrimesUpTo(maxNumber);
    }
}