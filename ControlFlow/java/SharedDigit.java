package ControlFlow.java;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));// → should return true since the digit 2 appears in both numbers

        System.out.println(hasSharedDigit(9, 99));// → should return false since 9 is not within the range of 10-99

        System.out.println(hasSharedDigit(15, 55));// → should return true since the digit 5 appears in both numbers

        System.out.println(hasSharedDigit(12, 13));
        
    }
    public static boolean hasSharedDigit(int number1, int number2){
        if (99 < number1 || number1 < 10 || 99 < number2 || number2 < 10){
            return false;
        }
        int value;
        while (number1 > 0){
            value = number1 % 10;
            System.out.println(value);
            int value2 = number2;
            while (value2 > 0){
                if (value == value2 % 10){
                    return true;
                }
                value2 /= 10;
            }
            number1 /= 10;
        }
        return false;
    }
}
