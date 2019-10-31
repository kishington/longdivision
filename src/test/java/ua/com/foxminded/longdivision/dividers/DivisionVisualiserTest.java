package ua.com.foxminded.longdivision.dividers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivisionVisualiserTest {
    private static DivisionVisualiser divisionVisualiser;

    @BeforeAll
    public static void initialise() {
        divisionVisualiser = new DivisionVisualiser();
    }

    @ParameterizedTest
    @CsvSource({ "78945, 4", "168345, 6", "0, 453", "25263263, 26302", "688438887, 1", "75499764, 75499764",
            "100000, 100", "120, 6" })
    void testDrawFirstThreeLines(int dividend, int divisor) {
        divisionVisualiser.drawFirstThreeLines(dividend, divisor);
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({ "78945, 4", "168345, 6", "0, 453", "25263263, 26302", "688438887, 1", "75499764, 75499764",
            "100000, 100", "120, 6" })
    void testVisualiseLongDivisionAlgorithm(int dividend, int divisor) {
        divisionVisualiser.visualiseLongDivisionAlgorithm(dividend, divisor);
        System.out.println();
    }
}
