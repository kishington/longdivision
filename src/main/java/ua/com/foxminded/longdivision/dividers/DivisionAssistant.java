package ua.com.foxminded.longdivision.dividers;

public class DivisionAssistant {

    public String dividend;
    public String divisor;

    public DivisionAssistant() {
        super();
    }

    public DivisionAssistant(int dividendInt, int divisorInt) {
        dividend = String.valueOf(dividendInt);
        divisor = String.valueOf(divisorInt);
    }

    public int[] divide(int dividend, int divisor) throws IllegalArgumentException {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("divident must be >= 0, divisor must be > 0");
        }

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int[] result = new int[] { quotient, remainder };

        return result;
    }



    public int[] performLongDivision(int originalDividend, int divisor) {
        DigitsHandler digitsHandler = new DigitsHandler();
        
        int fullQuotient = originalDividend / divisor;
        int numberOfFullQuotientDigits = digitsHandler.getNumberOfDigits(fullQuotient);
        int[] modifiedDividendDigits = digitsHandler.getDigits(originalDividend);

        int[] dividends = new int[numberOfFullQuotientDigits];

        int startIndex = 0;
        dividends[0] = getNextDividend(modifiedDividendDigits, startIndex, divisor);
        if (dividends.length >= 1) {
            for (int i = 1; i < dividends.length; i++) {
                int currentRemainder = dividends[i-1] % divisor;
                int currentRemainderLength = digitsHandler.getNumberOfDigits(currentRemainder); 
                int[] currentRemainderDigits = digitsHandler.getDigits(currentRemainder);
                
                int previousDividendLength = digitsHandler.getNumberOfDigits(dividends[i-1]);
                startIndex = startIndex + previousDividendLength - currentRemainderLength;
                
                modifiedDividendDigits = digitsHandler.replaceDigits(modifiedDividendDigits, startIndex, currentRemainderDigits);
                if (currentRemainder == 0) {
                   startIndex++;
                }
                dividends[i] = getNextDividend(modifiedDividendDigits, startIndex, divisor);
            }
        }
        return dividends;
    }

    public int getNextDividend(int[] digits, int startIndex, int divisor) {
        int endIndex = startIndex + 1;
        int dividend = digits[startIndex];
        while (dividend / divisor == 0 && endIndex < digits.length) {
            dividend = dividend * 10 + digits[endIndex];
            endIndex++;
        }
        return dividend;
    }

    
}
