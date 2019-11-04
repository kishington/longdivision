package ua.com.foxminded.longdivision.drawers;

public class Divider {

    public int[] divide(int dividend, int divisor) {
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int[] result = new int[] { quotient, remainder };

        return result;
    }

}

