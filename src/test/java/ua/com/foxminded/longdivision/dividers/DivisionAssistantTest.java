package ua.com.foxminded.longdivision.dividers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivisionAssistantTest {
    private static DivisionAssistant divisionAssistant;

    @BeforeAll
    public static void initialise() {
        divisionAssistant = new DivisionAssistant();
    }

    @ParameterizedTest
    @CsvSource({ "201, 1, 11, 1", "6510, 1, 11, 51", "4647210, 0, 4648, 46472" })
    void testGetNextDividend(int originalDividend, int startIndex, int divisor, int expectedOutput) {
        DigitsHandler digitBuilder = new DigitsHandler();
        int[] digits = digitBuilder.getDigits(originalDividend);
        int actualOutput = divisionAssistant.getNextDividend(digits, startIndex, divisor);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformLongDivision_NonZeroFinalRemainder() {
        int dividend = 168345;
        int divisor = 6;
        int[] expected = { 16, 48, 34, 45, 3 };
        int[] actual = divisionAssistant.performLongDivision(dividend, divisor);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testPerformLongDivision_FinalRemainderIsZero() {
        int dividend = 12834;
        int divisor = 6;
        int[] expected = { 12, 8, 23, 54 };
        int[] actual = divisionAssistant.performLongDivision(dividend, divisor);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testPerformLongDivision_DividendIsZero() {
        int dividend = 0;
        int divisor = 6;
        int[] expected = { 0 };
        int[] actual = divisionAssistant.performLongDivision(dividend, divisor);
        assertArrayEquals(expected, actual);
    }
}
