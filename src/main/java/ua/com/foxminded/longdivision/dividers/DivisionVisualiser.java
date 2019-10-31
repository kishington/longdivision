package ua.com.foxminded.longdivision.dividers;

public class DivisionVisualiser {

    private String divisor;
    private String dividend;

    public void visualiseLongDivisionAlgorithm(int dividendInt, int divisorInt) {

        DivisionAssistant divisionMate = new DivisionAssistant();
        
        int[] divisionResult = divisionMate.divide(dividendInt, divisorInt);
        int quotientInt = divisionResult[0];
        int remainderInt = divisionResult[1];

        dividend = String.valueOf(dividendInt);
        divisor = String.valueOf(divisorInt);
        String quotient = String.valueOf(quotientInt);
        String remainder = String.valueOf(remainderInt);

        System.out.println(dividend + "|" + divisor);
        for (int i = 0; i < dividend.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for (int i = 0; i < divisor.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < dividend.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|");

    }
    
    
}
