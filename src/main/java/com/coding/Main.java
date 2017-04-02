package com.coding;

/**
 * @author Brightsunrise
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        String request = "введённые пароли не совпадают";
        stringToUnicode(request);

    }

    private static void stringToUnicode(String input) {
        if(input != null) {
            input.chars().forEach(x -> System.out
                    .print("\\u" + Integer.toHexString(x | 0x10000).substring(1)));
        }
    }
}
