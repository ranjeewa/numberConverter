package com.ranjeewa;

public class NumberConverter {

    private static String[] TOTWENTY = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String[] TENS = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

    private final String ZERO = "zero";

    public String convertNumberToText(String number) {
        Integer intNum = Integer.parseInt(number);
        if (intNum < 100) {
            return convertLessThanHundred(intNum);
        } else {
            return "Number is too big (for now)";
        }
    }

    public String convertLessThanHundred(int number) {
        StringBuffer numString = new StringBuffer("");
        if (number == 0) {
            return ZERO;
        } else if (number < 20) {
            numString.append(TOTWENTY[number-1]);
        } else {
            //get first digit
            int tens = number/10;
            numString.append(TENS[tens]);
            if (number % 10 != 0) {
                numString.append(TOTWENTY[(number % 10) - 1]);
            }
        }
        return numString.toString().trim();
    }
}
