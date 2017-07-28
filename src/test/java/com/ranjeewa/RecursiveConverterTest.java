package com.ranjeewa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ranjeewa on 7/27/17.
 */
public class RecursiveConverterTest {

    @Test
    public void convertLessThanHundred() {
        RecursiveConverter converter = new RecursiveConverter();

        assertEquals("Zero", converter.convertNumberToText("0"));
        assertEquals("One", converter.convertNumberToText("1"));
        assertEquals("Nineteen", converter.convertNumberToText("19"));
        assertEquals("Twenty", converter.convertNumberToText("20"));
        assertEquals("Twenty one", converter.convertNumberToText("21"));
        assertEquals("Thirty seven", converter.convertNumberToText("37"));
        assertEquals("Twenty", converter.convertNumberToText("20"));
        assertEquals("Ninety nine", converter.convertNumberToText("99"));

    }

    @Test
    public void printAndWhenNeeded() {
        RecursiveConverter converter = new RecursiveConverter();

        assertEquals("one hundred and two", converter.convertHundreds(102, "").trim());
        assertEquals("one hundred two million", converter.convertHundreds(102, "million").trim());
        assertEquals("two hundred", converter.convertHundreds(200, "").trim());
    }

    @Test
    public void convertThousands() {
        RecursiveConverter converter = new RecursiveConverter();

        assertEquals("One thousand", converter.convertNumberToText("1000"));
        assertEquals("One thousand one hundred and fourteen", converter.convertNumberToText("1114"));
        assertEquals("Two thousand seven", converter.convertNumberToText("2007"));
        assertEquals("Six thousand seventy", converter.convertNumberToText("6070"));
        assertEquals("Nine thousand nine hundred and ninety nine", converter.convertNumberToText("9999"));
        assertEquals("One billion one hundred twenty three million four hundred fifty six thousand seven hundred and eighty nine",
                converter.convertNumberToText("1123456789"));
    }

    @Test
    public void handleNegativeNumbers() {
        RecursiveConverter converter = new RecursiveConverter();

        assertEquals("Negative two", converter.convertNumberToText("-2"));
        assertEquals("Negative three thousand four hundred and five", converter.convertNumberToText("-3405"));
    }


}
