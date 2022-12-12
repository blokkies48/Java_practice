package ControlFlow.java;

public class NumberPalindrome{
    public static void main(String[] args) {
        isPalindrome(-1221); // → should return true

        isPalindrome(707); // → should return true

        isPalindrome(11212); // → should return false because reverse is 21211 and that is not equal to 11212.
        System.out.println(isPalindrome(11));

        
    }
    public static boolean isPalindrome(int number){
        int checkNumber = number;
        int reverseNumber = 0;
        if (number < 0){
            number = -(number);
            checkNumber = -(checkNumber);
        }

        while (number > 0){
            int lastDigit = (number % 10);
            reverseNumber *= 10;
            reverseNumber += lastDigit;
            number /= 10;
        }


        return checkNumber == reverseNumber;
    }
}