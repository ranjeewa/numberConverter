package com.ranjeewa;

public class NumberConverter {

    private static String[] TOTWENTY = {"one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
            "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};

    private static String[] TENS = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

    private final String ZERO = "zero";

    String convertNumberToText(String number) {

        if (number.length() < 5) {
            Integer intNum = Integer.parseInt(number);
            return convertHundreds(intNum);
        } else {
            return "Number is too big (for now)";
        }
    }

    String convertHundreds(int number) {
        StringBuilder numString = new StringBuilder("");
        if (number == 0) {
            return ZERO;
        }

        if (number/100 > 0) { //print the hundreds
            numString.append(TOTWENTY[(number/100) - 1]);
            numString.append("hundred ");
            number = number % 100;
        }
        if (number >= 20) { //print the tens (except for 11-19)
            //get first digit
            int tens = number/10;
            numString.append(TENS[tens]);
            if (number % 10 != 0) {
                numString.append(TOTWENTY[(number % 10) - 1]);
            }
        } else if (number > 0) { //print the ones or teens
            numString.append(TOTWENTY[number-1]);
        }
        return numString.toString().trim();
    }
}
