package ControlFlow.java;

public class LastDigitChecker{
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit (41, 22, 71));// → should return true since 1 is the rightmost digit in numbers 41 and 71

        System.out.println(hasSameLastDigit (23, 32, 42));// → should return true since 2 is the rightmost digit in numbers 32 and 42

        System.out.println(hasSameLastDigit (9, 99, 999));// → should return false since 9 is not within the range of 10-1000


        System.out.println(isValid(10));// → should return true since 10 is within the range of 10-1000

        System.out.println(isValid(468));// → should return true since 468 is within the range of 10-1000

        System.out.println(isValid(1051));// → should return false since 1051 is not within the range of 10-1000
    }
    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        int value1 = number1 % 10;
        int value2 = number2 % 10;
        int value3 = number3 % 10;
        if (isValid(number1) && isValid(number2) && isValid(number3)){
            if (value1 == value2 || value1 == value3 || value2 == value3){
                return true;
            }
        }
        return false;
    }
    public static boolean isValid(int number){
        return !(number < 10 || number > 1000);
    }
}