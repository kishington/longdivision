package ua.com.foxminded.longdivision.dividers;

public class DivisionVisualiser {

    public void visualise(int dividend, int divisor) {
        drawFirstThreeLines(dividend, divisor);

        DigitsHandler digitsHandler = new DigitsHandler();
        DivisionAssistant divisionAssistant = new DivisionAssistant();

        int[] interimDividends = divisionAssistant.performLongDivision(dividend, divisor);
        int remainder = dividend % divisor;
        int currentMultiple = interimDividends[0] / divisor * divisor;
        int currentRemainder = interimDividends[0] % divisor;

        int remainderLength = digitsHandler.getNumberOfDigits(remainder);
        int currentInterimDividendLength = digitsHandler.getNumberOfDigits(interimDividends[0]);
        int currentMultipleLength = digitsHandler.getNumberOfDigits(currentMultiple);
        int currentRemainderLength = digitsHandler.getNumberOfDigits(currentRemainder);

        int numberOfSpacesFromLeftEdge = 1 + currentInterimDividendLength - currentMultipleLength;

        for (int i = 1; i < interimDividends.length; i++) {
            if (currentRemainder != 0) {
                numberOfSpacesFromLeftEdge += currentMultipleLength - currentRemainderLength - 1;
            } else {
                numberOfSpacesFromLeftEdge += currentMultipleLength - currentRemainderLength;
            }
            printCharNTimes(' ', numberOfSpacesFromLeftEdge);
            System.out.print("_" + interimDividends[i] + "\n");

            currentMultiple = interimDividends[i] / divisor * divisor;
            currentRemainder = interimDividends[i] % divisor;
            currentMultipleLength = digitsHandler.getNumberOfDigits(currentMultiple);
            currentInterimDividendLength = digitsHandler.getNumberOfDigits(interimDividends[i]);
            numberOfSpacesFromLeftEdge += 1 + currentInterimDividendLength - currentMultipleLength;
            printCharNTimes(' ', numberOfSpacesFromLeftEdge);
            System.out.print(currentMultiple + "\n");

            printCharNTimes(' ', numberOfSpacesFromLeftEdge);
            printCharNTimes('-', currentMultipleLength);
            System.out.println();
        }
        numberOfSpacesFromLeftEdge += currentMultipleLength - remainderLength;
        printCharNTimes(' ', numberOfSpacesFromLeftEdge);
        System.out.println(remainder);

    }

    void drawFirstThreeLines(int dividend, int divisor) {

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
        } else {
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
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ch;
        }
        String str = new String(chars);
        System.out.print(str);
    }
}
