package ua.com.foxminded.longdivision.dividers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ua.com.foxminded.longdivision.dividers.DivisionAssistant;

class DivisionVisualiserTest {
    private static DivisionAssistant divisionAssistant;
    private static DivisionVisualiser divisionVisualiser;
    
    @BeforeAll
    public static void initialise() {
        divisionAssistant = new DivisionAssistant();
        divisionVisualiser = new DivisionVisualiser();
    }

    @Test
    void testVisualiseLongDivisionAlgorithm() {
        int dividendInt = 78945;
        int divisorInt = 4;
        divisionVisualiser.visualiseLongDivisionAlgorithm(dividendInt, divisorInt);
    }
    
 /*   
    @Test
    public void divide_NegativeNumberAs1stArgument_IllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> divisionAssistant.divide(-4, 6));
    }
    
    @Test
    public void divide_NegativeNumberAs2ndArgument_IllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> divisionAssistant.divide(2, -8));
    }
    
    @Test
    public void divide_ZeroAs2ndArgument_ArithmeticExceptionThrown() {
        assertThrows(ArithmeticException.class, () -> divisionAssistant.divide(4, 0));
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
        int[] actualResult = divisionAssistant.divide(dividend, divisor);
        assertArrayEquals(expectedResult, actualResult);
    }
*/
}

