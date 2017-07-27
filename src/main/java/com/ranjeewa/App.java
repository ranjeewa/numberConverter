package com.ranjeewa;

import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        NumberConverter converter = new NumberConverter();
        boolean exit = false;

        while (!exit){
            printUsage();
            input = scanner.nextLine();
            if ("Q".equals(input.toUpperCase())) {
                exit = true;
            } else {
                if (isValidInput(input)) {
                    String asText = converter.convertNumberToText(input);
                    System.out.println(asText);
                } else {
                    printBadInputMessage(input);
                }
            }
        }
        System.out.println("Thank you.");
    }

    private static void printUsage() {
        System.out.println("Enter an integer to be printed as text, or Q to quit :");
    }

    private static void printBadInputMessage(String badInput) {
        System.out.println(badInput + " is not a valid integer. Please try again.");
    }

    static boolean isValidInput(String inputString) {
        try {
            Integer intValue = Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static String convertToText(String input) {
        return input;
    }
}
