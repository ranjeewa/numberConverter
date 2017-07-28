package com.ranjeewa;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple NumberConverter.
 */
public class NumberConverterTest
{

    @Test
    public void testValidInput() {
        confirmValid("0");
        confirmValid("12");
        confirmValid("100");
        confirmValid("-456");
        confirmValid("1232546354");
    }

    @Test
    public void testInvalidInput() {
        confirmInvalid("Q");
        confirmInvalid("asdfg");
        confirmInvalid("100w");
        confirmInvalid("5,278");
    }

    private static void confirmValid(String validInt) {
        assertTrue(validInt + " should be a valid input", NumberConverter.isValidInput(validInt));
    }

    private static void confirmInvalid(String invalidInt) {
        assertFalse(invalidInt + " should be an invalid input", NumberConverter.isValidInput(invalidInt));
    }

}
