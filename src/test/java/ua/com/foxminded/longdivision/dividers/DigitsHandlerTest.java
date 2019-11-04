package ua.com.foxminded.longdivision.dividers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DigitsHandlerTest {

    private static DigitsHandler digitsHandler;

    @BeforeAll
    public static void initialise() {
        digitsHandler = new DigitsHandler();
    }

    @ParameterizedTest(name = "number {0} consists of {1} digits")
    @CsvSource({ "0, 1", "23, 2", "560, 3", "4647210, 7" })
    void testGetNumberOfDigits(int input, int expectedOutput) {
        int actualOutput = digitsHandler.getNumberOfDigits(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGetDigits() {
        int number = 234678;
        int[] expected = { 2, 3, 4, 6, 7, 8 };
        int[] actual = digitsHandler.getDigits(number);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testReplaceDigits() {
        int startIndex = 3;
        int[] newDigits = { 5, 9, 3 };
        int[] digits = { 7, 9, 0, 3, 4, 2, 4 };
        int[] expected = { 7, 9, 0, 5, 9, 3, 4 };
        int[] actual = digitsHandler.replaceDigits(digits, startIndex, newDigits);
        assertArrayEquals(expected, actual);

    }

}
