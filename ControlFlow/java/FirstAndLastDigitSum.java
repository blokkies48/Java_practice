package ControlFlow.java;

public class FirstAndLastDigitSum {
    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(252)); //→ should return 4, the first digit is 2 and the last is 2 which gives us 2+2 and the sum is 4.

        sumFirstAndLastDigit(257); //→ should return 9, the first digit is 2 and the last is 7 which gives us 2+7 and the sum is 9.

        sumFirstAndLastDigit(0); //→ should return 0, the first digit and the last digit is 0 since we only have 1 digit, which gives us 0+0 and the sum is 0.

        sumFirstAndLastDigit(5); //→ should return 10, the first digit and the last digit is 5 since we only have 1 digit, which gives us 5+5 and the sum is 10.

        System.out.println(sumFirstAndLastDigit(-10)); //→ should return -1, since the parameter is negative and needs to be positive.
        
    }
    public static int sumFirstAndLastDigit(int number){
        int lastDigit = 0;
        if (number < 0){
            return -1;
        }
        else if(number <= 9){
            return (number * 2);
        }
        int firstLoop = 0;
        while (number > 9){
            if (firstLoop == 0){
                lastDigit = number % 10;
            }
            number /= 10;
            firstLoop++;
        }
        return number + lastDigit;
    }

}
