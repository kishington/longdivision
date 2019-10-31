package ua.com.foxminded.longdivision.dividers;

public class DigitsHandler {

    int[] replaceDigits(int[] digits, int startIndex, int[] newDigits) {
        int newDigitsIndex = 0;
        for(int i = startIndex; i < startIndex + newDigits.length; i++) {
            digits[i] = newDigits[newDigitsIndex];
            newDigitsIndex++;
        }
        return digits;
    }
    

    public int[] getDigits(int number) {
        int numberOfDigits = getNumberOfDigits(number);
        int[] digits = new int[numberOfDigits];

        for (int i = digits.length -1; i >= 0; i--){
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }
    
    
    int getNumberOfDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int numberOfDigits = 0;
        while (number != 0) {
            number = number / 10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }
    
}
