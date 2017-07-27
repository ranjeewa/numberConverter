package com.ranjeewa;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {

    @Test
    public void convertLessThanHundred() throws Exception {
        NumberConverter converter = new NumberConverter();

        assertEquals("zero", converter.convertHundreds(0));
        assertEquals("one", converter.convertHundreds(1));
        assertEquals("nineteen", converter.convertHundreds(19));
        assertEquals("twenty", converter.convertHundreds(20));
        assertEquals("twenty one", converter.convertHundreds(21));
        assertEquals("thirty seven", converter.convertHundreds(37));
        assertEquals("twenty", converter.convertHundreds(20));
        assertEquals("ninety nine", converter.convertHundreds(99));

    }

    @Test
    public void convertHundreds() throws Exception {
        NumberConverter converter = new NumberConverter();

        assertEquals("one hundred", converter.convertHundreds(100));
        assertEquals("one hundred fourteen", converter.convertHundreds(114));
        assertEquals("three hundred forty seven", converter.convertHundreds(347));
        assertEquals("six hundred seventy", converter.convertHundreds(670));
        assertEquals("nine hundred ninety nine", converter.convertHundreds(999));

    }
}