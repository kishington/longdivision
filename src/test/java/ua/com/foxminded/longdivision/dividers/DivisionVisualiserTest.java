package ua.com.foxminded.longdivision.dividers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DivisionVisualiserTest {
    private static DivisionVisualiser divisionVisualiser;

    @BeforeAll
    public static void initialise() {
        divisionVisualiser = new DivisionVisualiser();
    }
    
    @Test
    void testVisualise() {
        int dividend = 78945;
        int divisor = 4;
        String expectedOutput = 
                "_78945|4\n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    void testVisualise_dividendIsZero() {
        int dividend = 0;
        int divisor = 453;
        String expectedOutput = 
                "_0|453\n" +
                " 0|---\n" +
                " -|0\n" +
                " 0\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    void testVisualise_bigNumbers() {
        int dividend = 25276229;
        int divisor = 26302;
        String expectedOutput = 
                "_25276229|26302\n" + 
                " 236718  |-----\n" + 
                " ------  |961\n" + 
                " _160442\n" + 
                "  157812\n" + 
                "  ------\n" + 
                "   _26309\n" + 
                "    26302\n" + 
                "    -----\n" + 
                "        7\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    void testVisualise_divisorIsOne() {
        int dividend = 68843;
        int divisor = 1;
        String expectedOutput = 
                "_68843|1\n" + 
                " 6    |-----\n" + 
                " -    |68843\n" + 
                " _8\n" + 
                "  8\n" + 
                "  -\n" + 
                "  _8\n" + 
                "   8\n" + 
                "   -\n" + 
                "   _4\n" + 
                "    4\n" + 
                "    -\n" + 
                "    _3\n" + 
                "     3\n" + 
                "     -\n" + 
                "     0\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    void testVisualise_dividendEqualsDivisor() {
        int dividend = 75499764;
        int divisor = 75499764;
        String expectedOutput = 
                "_75499764|75499764\n" + 
                " 75499764|--------\n" + 
                " --------|1\n" + 
                "        0\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    void testVisualise_dividendAndDivisorMultiplesOfTen() {
        int dividend = 10000;
        int divisor = 100;
        String expectedOutput = 
                "_10000|100\n" + 
                " 100  |---\n" + 
                " ---  |100\n" + 
                "   _0\n" + 
                "    0\n" + 
                "    -\n" + 
                "    _0\n" + 
                "     0\n" + 
                "     -\n" + 
                "     0\n";
        String actualOutput = divisionVisualiser.visualise(dividend, divisor);
        System.out.println(divisionVisualiser.visualise(dividend, divisor));
        assertEquals(expectedOutput,actualOutput);
    }
}
