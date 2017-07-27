package com.ranjeewa;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {

    @Test
    public void convertLessThanHundred() throws Exception {
        NumberConverter converter = new NumberConverter();

        assertEquals("zero", converter.convertLessThanHundred(0));
        assertEquals("one", converter.convertLessThanHundred(1));
        assertEquals("nineteen", converter.convertLessThanHundred(19));
        assertEquals("twenty", converter.convertLessThanHundred(20));
        assertEquals("twenty one", converter.convertLessThanHundred(21));
        assertEquals("thirty seven", converter.convertLessThanHundred(37));
        assertEquals("ninety nine", converter.convertLessThanHundred(99));



    }

}