package ua.com.foxminded.longdivision.drawers;

public class DivisionMate {

    public int[] divide(int dividend, int divisor) throws IllegalArgumentException {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("divident must be >= 0, divisor must be > 0");
        }
        
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int[] result = new int[] { quotient, remainder };

        return result;
    }

}

