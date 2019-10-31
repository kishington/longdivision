package ua.com.foxminded.longdivision.dividers;

public class DivisionAssistant {

    public int[] performLongDivision(int dividend, int divisor) throws IllegalArgumentException {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("divident must be >= 0, divisor must be > 0");
        }

        DigitsHandler digitsHandler = new DigitsHandler();

        int quotient = dividend / divisor;
        int quotientLength = digitsHandler.getNumberOfDigits(quotient);
        int[] modifiedDividendDigits = digitsHandler.getDigits(dividend);

        int[] interimDividends = new int[quotientLength];

        int startIndex = 0;
        interimDividends[0] = getNextDividend(modifiedDividendDigits, startIndex, divisor);

        for (int i = 1; i < interimDividends.length; i++) {
            int currentRemainder = interimDividends[i - 1] % divisor;
            int currentRemainderLength = digitsHandler.getNumberOfDigits(currentRemainder);
            int[] currentRemainderDigits = digitsHandler.getDigits(currentRemainder);

            int previousDividendLength = digitsHandler.getNumberOfDigits(interimDividends[i - 1]);
            startIndex = startIndex + previousDividendLength - currentRemainderLength;

            modifiedDividendDigits = digitsHandler.replaceDigits(modifiedDividendDigits, startIndex,
                    currentRemainderDigits);
            if (currentRemainder == 0) {
                startIndex++;
            }
            interimDividends[i] = getNextDividend(modifiedDividendDigits, startIndex, divisor);
        }

        return interimDividends;
    }

    int getNextDividend(int[] digits, int startIndex, int divisor) {
        int endIndex = startIndex + 1;
        int dividend = digits[startIndex];
        while (dividend / divisor == 0 && endIndex < digits.length) {
            dividend = dividend * 10 + digits[endIndex];
            endIndex++;
        }
        return dividend;
    }
}
