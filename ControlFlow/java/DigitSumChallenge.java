package ControlFlow.java;

public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigit(10001)); 
        System.out.println(sumDigit2(10001)); 
        System.out.println(sumDigit(32456)); 
        System.out.println(sumDigit2(32456)); 
        System.out.println(sumDigit2(-32456)); 
        System.out.println(sumDigit2(1234)); 
        System.out.println(sumDigit2(9)); 
        System.out.println(sumDigit2(1)); 
        System.out.println(sumDigit2(0)); 
        
    }
    public static int sumDigit(int value) {
        if (value < 0) {
            return -1;
        }

        int returnSum = 0;
        String str = Integer.toString(value);
        int newNumber;

        for (int i = 0; i < str.length(); i++) {
            newNumber = Character.getNumericValue(str.charAt(i));
            returnSum += newNumber; 
        }
        return returnSum;
    }
    public static int sumDigit2(int value) {
        if (value < 0) {
            return -1;
        }
        int returnSum = 0;
        while (value > 0) {
            returnSum += (value % 10);
            value /= 10;
        }
        return returnSum;
    }
}
