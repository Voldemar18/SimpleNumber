package ru.student.testing;

public enum MenuOption {
    FIND_PRIMES(1, "Найти простые числа от 1 до N"),
    EXIT(2, "Завершить программу");

    private final int code;
    private final String description;

    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) {
                return option;
            }
        }
        return null;
    }

    public static String getValidCodes() {
        StringBuilder sb = new StringBuilder();
        for (MenuOption option : values()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(option.code);
        }
        return sb.toString();
    }
}