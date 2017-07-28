package com.ranjeewa;

import java.util.*;

/**
 * Created by ranjeewa on 7/27/17.
 */
public class RecursiveConverter {

    private static String[] TOTWENTY = {"one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
            "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};

    private static String[] TENS = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

    private final String ZERO = "Zero";

    private static final List<String> suffixes = Arrays.asList("", "thousand ", "million ", "billion ", "trillion ");


    String convertNumberToText(String number) {
        //remove the '-' sign if it exists
        StringBuilder numberAsText = new StringBuilder();
        if (number.charAt(0) == '-') {
            numberAsText.append("negative ");
            number = number.substring(1);
        }

        //short circuit for zero
        if ("0".equals(number)) {
            return ZERO;
        }

        //convert the number to text
        ListIterator<String> suffixIterator = suffixes.listIterator();
        numberAsText.append(recursiveConvert(number, suffixIterator));

        //prettify the output
        StringBuilder prettyText = new StringBuilder(numberAsText.substring(0,1).toUpperCase());
        prettyText.append(numberAsText.substring(1));
        return prettyText.toString().trim();
    }

    private String recursiveConvert(String number, ListIterator<String> suffixIterator) {

        int numLengthNow = number.length();
        //if there are more than 3 digits left, we'll need to loop through again
        if (numLengthNow > 3) {
            //extract the last 3 digits, convert to text, and add correct 'suffix', e.g. 'million'
            String last3Digits = number.substring(numLengthNow - 3, numLengthNow);
            String nextSuffix = suffixIterator.next();
            StringBuilder last3DigitsAsText = new StringBuilder(convertHundreds(Integer.parseInt(last3Digits), nextSuffix));

            //remove the last 3 digits, and loop through again
            String nextNumber = number.substring(0, numLengthNow - 3);
            return recursiveConvert(nextNumber, suffixIterator) + last3DigitsAsText;
        } else {
            //exit condition, convert first digits to text and add suffix
            return convertHundreds(Integer.parseInt(number), suffixIterator.next());
        }
    }

    String convertHundreds(int number, String suffix) {
        //short circuit if nothing to print
        if (number == 0) {
            return "";
        }
        StringBuilder hundreds = new StringBuilder("");

        if (number/100 > 0) { //print the hundreds
            hundreds.append(TOTWENTY[(number/100) - 1]);
            hundreds.append("hundred ");
            number = number % 100;
        }

        StringBuilder tensAndOnes = new StringBuilder();
        if (number >= 20) { //print the tens (except for 11-19)
            //get first digit
            int tens = number/10;
            tensAndOnes.append(TENS[tens]);
            if (number % 10 != 0) {
                tensAndOnes.append(TOTWENTY[(number % 10) - 1]);
            }
        } else if (number > 0) { //print the ones or teens
            tensAndOnes.append(TOTWENTY[number-1]);
        }

        //add the 'and' between hundreds and tens, as appropriate, e.g. one hundred and one
        StringBuilder asText = new StringBuilder();
        if (tensAndOnes.length() > 0) {
            //only print 'and' for the last 3 digits
            if ((hundreds.length() > 0) && (suffix.length() == 0)) {
                asText.append("and ");
            }
            asText.append(tensAndOnes);
        }
        asText.append(suffix);
        hundreds.append(asText);

        return hundreds.toString();
    }

}
