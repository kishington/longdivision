package ua.com.foxminded.longdivision.dividers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ua.com.foxminded.longdivision.dividers.DivisionMate;

class DivisionVisualiserTest {
    private static DivisionMate divisionMate;
    
    @BeforeAll
    public static void initialise() {
        divisionMate = new DivisionMate();
    }

    @Test
    public void divide_NegativeNumberAs1stArgument_IllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> divisionMate.divide(-4, 6));
    }
    
    @Test
    public void divide_NegativeNumberAs2ndArgument_IllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> divisionMate.divide(2, -8));
    }
    
    @Test
    public void divide_ZeroAs2ndArgument_ArithmeticExceptionThrown() {
        assertThrows(ArithmeticException.class, () -> divisionMate.divide(4, 0));
    }
    
    
    @ParameterizedTest(name = "{0} divided by {1} is {2} and {3} remainder")
    @CsvSource({ 
        "3, 2, 1, 1",
        "0, 30, 0, 0",
        "6, 4, 1, 2",
        "43, 20, 2, 3"

    })
    void divide_ValidArgumentsPassed_ReturnsCorrectOutput(int dividend, int divisor, int expectedQuotient, int expectedRemainder) {
        int[] expectedResult = new int[] {expectedQuotient, expectedRemainder};
        int[] actualResult = divisionMate.divide(dividend, divisor);
        assertArrayEquals(expectedResult, actualResult);
    }

}

