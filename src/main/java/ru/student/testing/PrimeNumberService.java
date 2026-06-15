package ru.student.testing;

public class PrimeNumberService {

    public void printAllNumbersUpTo(int limit) {
        System.out.print("Все числа от 1 до " + limit + ": ");
        for (int i = 1; i <= limit; i++) {
            System.out.print(i);
            if (i < limit) System.out.print(", ");
        }
        System.out.println();
    }

    public void printPrimesUpTo(int limit) {
        System.out.print("Простые числа от 2 до " + limit + ": ");
        boolean foundPrime = false;

        for (int number = 2; number <= limit; number++) {
            if (isPrime(number)) {
                if (foundPrime) System.out.print(", ");
                System.out.print(number);
                foundPrime = true;
            }
        }

        if (!foundPrime) System.out.print("нет простых чисел");
        System.out.println();
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
}