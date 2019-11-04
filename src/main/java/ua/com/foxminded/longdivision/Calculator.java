package ua.com.foxminded.longdivision;

import ua.com.foxminded.longdivision.dividers.DivisionVisualiser;

public class Calculator {

    public static void main(String[] args) {
        int dividend = 78945;
        int divisor = 4;

        DivisionVisualiser divisionVisualiser = new DivisionVisualiser();
        String visualisedDivisionResult = divisionVisualiser.visualise(dividend, divisor);
        System.out.println(visualisedDivisionResult);
    }
}
