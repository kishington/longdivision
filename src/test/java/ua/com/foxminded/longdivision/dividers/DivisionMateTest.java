package ua.com.foxminded.longdivision.dividers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivisionMateTest {
    private static DivisionMate divisionMate;
    
    @BeforeAll
    public static void initialise() {
        divisionMate = new DivisionMate();
    }

    @Test
    void testPerformLongDivision() {
        int[] actualOutput = divisionMate.performLongDivision(16834, 6);
        int[] expectedOutput = {16, 48, 34};
    }

    @ParameterizedTest
    @CsvSource({ "201, 1, 11, 1", "6510, 1, 11, 51", "4647210, 0, 4648, 46472" })
    void testGetNextDividend(int originalDividend, int startIndex, int divisor, int expectedOutput) {
        DigitBuilder digitBuilder = new DigitBuilder();
        int[] digits = digitBuilder.getDigits(originalDividend);
        int actualOutput =  divisionMate.getNextDividend(digits, startIndex, divisor);
        assertEquals(expectedOutput, actualOutput);
    }
    
}
