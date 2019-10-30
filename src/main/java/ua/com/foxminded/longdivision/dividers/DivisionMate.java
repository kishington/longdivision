package ua.com.foxminded.longdivision.dividers;

public class DivisionMate {

    public String dividend;
    public String divisor;

    public DivisionMate() {
        super();
    }

    public DivisionMate(int dividendInt, int divisorInt) {
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
        DigitBuilder digitBuilder = new DigitBuilder();
        
        int fullQuotient = originalDividend / divisor;
        int numberOfFullQuotientDigits = digitBuilder.getNumberOfDigits(fullQuotient);
        int[] digits = digitBuilder.getDigits(originalDividend);

        int[] dividends = new int[numberOfFullQuotientDigits];

        int startIndex = digits.length - 1;
        dividends[0] = getNextDividend(digits, startIndex, divisor);
        if (dividends.length >= 1) {
            int remainder = dividends[0] % divisor;
            for (int i = 1; i < dividends.length; i++) {
                
                dividends[i] = getNextDividend(digits, startIndex, divisor);
                
                int currentDividendLength = digitBuilder.getNumberOfDigits(dividends[i]);
                startIndex = startIndex - currentDividendLength;
            }
        }
        return dividends;
    }
    



    public int getNextDividend2(int[] digits, int startIndex, int divisor) {
        int endIndex = startIndex - 1;
        int numToDivide = digits[startIndex];
        while (numToDivide / divisor == 0 && endIndex >= 0) {
            numToDivide = numToDivide * 10 + digits[endIndex];
            endIndex--;
        }
        return numToDivide;
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
