package ru.student.testing;

public class Menu {
    private final ConsoleReader consoleReader;
    private final PrimeNumberService primeService;

    public Menu(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
        this.primeService = new PrimeNumberService();
    }
    public void start() {
        MenuOption choice;
        do {
            printMenu();
            choice = consoleReader.readMenuChoice();

            if (choice == null) {
                System.out.println("ОШИБКА: Введите одно из значений: " + MenuOption.getValidCodes());
                continue;
            }

            switch (choice) {
                case FIND_PRIMES -> executeFindPrimes();
                case EXIT -> System.out.println("Завершение программы...");
            }
        } while (choice != MenuOption.EXIT);
    }

    private void printMenu() {
        System.out.println("\n\n--------------МЕНЮ-------------");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + " - " + option.getDescription());
        }
        System.out.print("Выберите действие: ");
    }
    private int readValidNumber() {
        Integer maxNumber = null;
        boolean valid = false;

        while (!valid) {
            System.out.print("Введите число N (от 2 до 1000000): ");
            maxNumber = consoleReader.readInt();

            if (maxNumber == null) {
                System.out.println("Ошибка: Введите целое число!");
                continue;
            }

            if (maxNumber < 2) {
                System.out.println("Ошибка: Число должно быть не меньше 2");
            } else if (maxNumber > 1_000_000) {
                System.out.println("Ошибка: Число не больше 1_000_000");
            } else {
                valid = true;
            }
        }
        return maxNumber;
    }

    private void executeFindPrimes() {
        int maxNumber = readValidNumber();
        primeService.printAllNumbersUpTo(maxNumber);
        primeService.printPrimesUpTo(maxNumber);
    }


}