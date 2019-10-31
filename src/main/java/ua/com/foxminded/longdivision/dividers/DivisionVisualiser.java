package ua.com.foxminded.longdivision.dividers;

public class DivisionVisualiser {

    public void visualiseLongDivisionAlgorithm(int dividend, int divisor) {
        
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        DigitsHandler digitsHandler = new DigitsHandler();
        int dividendLength = digitsHandler.getNumberOfDigits(dividend);
        int divisorLength = digitsHandler.getNumberOfDigits(divisor);
        int quotientLength = digitsHandler.getNumberOfDigits(quotient);
        int remainderLength = digitsHandler.getNumberOfDigits(remainder);

        DivisionAssistant divisionAssistant = new DivisionAssistant();
        int[] interimDividends = divisionAssistant.performLongDivision(dividend, divisor);
        int currentInterimDividendLength = digitsHandler.getNumberOfDigits(interimDividends[0]);
        int currentMultiple = interimDividends[0] / divisor * divisor;
        int currentMultipleLength = digitsHandler.getNumberOfDigits(currentMultiple);
        
        
        System.out.println("_" + dividend + "|" + divisor);
        
        int numberOfSpacesFromLeftEdge = 1 + currentInterimDividendLength - currentMultipleLength;
        printCharNTimes(' ', numberOfSpacesFromLeftEdge);
        System.out.print(currentMultiple);
        printCharNTimes(' ', dividendLength - currentMultipleLength);
        System.out.print("|");
        if (divisorLength > quotientLength) {
            printCharNTimes('-', divisorLength);
        }
        else {
            printCharNTimes('-', quotientLength);
        }
        System.out.println();
        printCharNTimes(' ', numberOfSpacesFromLeftEdge);
        printCharNTimes('-', currentMultipleLength);
        printCharNTimes(' ', dividendLength - currentMultipleLength);
        System.out.println("|" + quotient);
      
    }
    
public void drawFirstThreeLines(int dividend, int divisor) {
        
        int quotient = dividend / divisor;

        DigitsHandler digitsHandler = new DigitsHandler();
        DivisionAssistant divisionAssistant = new DivisionAssistant();
        
        int[] interimDividends = divisionAssistant.performLongDivision(dividend, divisor);
        int firstMultiple = interimDividends[0] / divisor * divisor;
        
        int dividendLength = digitsHandler.getNumberOfDigits(dividend);
        int divisorLength = digitsHandler.getNumberOfDigits(divisor);
        int quotientLength = digitsHandler.getNumberOfDigits(quotient);
        int firstInterimDividendLength = digitsHandler.getNumberOfDigits(interimDividends[0]);
        int firstMultipleLength = digitsHandler.getNumberOfDigits(firstMultiple);
        
        int numberOfSpacesFromLeftEdge = 1 + firstInterimDividendLength - firstMultipleLength;
        
        
        System.out.println("_" + dividend + "|" + divisor);
        
        
        printCharNTimes(' ', numberOfSpacesFromLeftEdge);
        System.out.print(firstMultiple);
        int numberOfSpacesTillBar = 1 + dividendLength - numberOfSpacesFromLeftEdge - firstMultipleLength;
        printCharNTimes(' ', numberOfSpacesTillBar);
        System.out.print("|");
        if (divisorLength > quotientLength) {
            printCharNTimes('-', divisorLength);
        }
        else {
            printCharNTimes('-', quotientLength);
        }
        System.out.println();
        
        
        printCharNTimes(' ', numberOfSpacesFromLeftEdge);
        printCharNTimes('-', firstMultipleLength);
        printCharNTimes(' ', numberOfSpacesTillBar);
        System.out.println("|" + quotient);
    }
    
    
    public void printCharNTimes(char ch, int n) {
        char[] chars = new char[n];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = ch;
        }
        String str = new String(chars);
        System.out.print(str);
    }
}
