package ua.com.foxminded.longdivision;

import ua.com.foxminded.longdivision.dividers.DivisionAssistant;

public class Calculator {

    public static void main(String[] args) {
        DivisionAssistant dMate = new DivisionAssistant();

        int dividend = 675342;
        int divisor = 68;
        int[] digits = dMate.getDigits(dividend);
        int nextDividend = dMate.getNextDividend(digits, digits.length - 1, divisor);
        System.out.println("original dividend: " + dividend);
        System.out.print("original dividend digits: ");
        for (int digit : digits)
            System.out.print(digit + " ");
        System.out.println();
        System.out.println("divisor: " + divisor);
        System.out.println("number to divide: " + nextDividend);

        System.out.println();
        dMate.visualiseLongDivisionAlgorithm(dividend, divisor);

        int[][] output = dMate.performLongDivision(dividend, divisor);
        System.out.print("dividends: ");
        for (int dividends : output[0])
            System.out.print(dividends + " ");
        System.out.println();
        
        System.out.print("multiples: ");
        for (int multiple : output[1])
            System.out.print(multiple + " ");
        System.out.println();
        

    }

}
