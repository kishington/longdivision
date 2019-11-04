package ua.com.foxminded.longdivision.dividers;

public class DivisionVisualiser {

    public String visualise(int dividend, int divisor) {
        StringBuilder output = getFirstThreeLines(dividend, divisor);

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
            output.append(lPad(' ', numberOfSpacesFromLeftEdge));
            output.append("_" + interimDividends[i] + "\n");

            currentMultiple = interimDividends[i] / divisor * divisor;
            currentRemainder = interimDividends[i] % divisor;
            currentMultipleLength = digitsHandler.getNumberOfDigits(currentMultiple);
            currentRemainderLength = digitsHandler.getNumberOfDigits(currentRemainder);
            currentInterimDividendLength = digitsHandler.getNumberOfDigits(interimDividends[i]);
            numberOfSpacesFromLeftEdge += 1 + currentInterimDividendLength - currentMultipleLength;
            output.append(lPad(' ', numberOfSpacesFromLeftEdge));
            output.append(currentMultiple + "\n");

            output.append(lPad(' ', numberOfSpacesFromLeftEdge));
            output.append(lPad('-', currentMultipleLength));
            output.append("\n");
        }
        numberOfSpacesFromLeftEdge += currentMultipleLength - remainderLength;
        output.append(lPad(' ', numberOfSpacesFromLeftEdge));
        output.append(remainder + "\n");

        return output.toString();
    }

    public StringBuilder getFirstThreeLines(int dividend, int divisor) {

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

        StringBuilder firstThreeLines = new StringBuilder();
        firstThreeLines.append("_" + dividend + "|" + divisor + "\n");

        firstThreeLines.append(lPad(' ', numberOfSpacesFromLeftEdge));
        firstThreeLines.append(firstMultiple);
        int numberOfSpacesTillBar = 1 + dividendLength - numberOfSpacesFromLeftEdge - firstMultipleLength;
        firstThreeLines.append(lPad(' ', numberOfSpacesTillBar));
        firstThreeLines.append('|');
        if (divisorLength > quotientLength) {
            firstThreeLines.append(lPad('-', divisorLength));
        } else {
            firstThreeLines.append(lPad('-', quotientLength));
        }
        firstThreeLines.append("\n");

        firstThreeLines.append(lPad(' ', numberOfSpacesFromLeftEdge));
        firstThreeLines.append(lPad('-', firstMultipleLength));
        firstThreeLines.append(lPad(' ', numberOfSpacesTillBar));
        firstThreeLines.append("|" + quotient + "\n");
        
        return firstThreeLines;
    }
    
    private StringBuilder lPad(char ch, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return (sb);
    }
}
