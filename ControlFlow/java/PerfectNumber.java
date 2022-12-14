package ControlFlow.java;

public class PerfectNumber {
    public static void main(String[] args) {

        isPerfectNumber(6); //should return true since its proper divisors are 1, 2, 3 and the sum is 1 + 2 + 3 = 6

        isPerfectNumber(28); //should return true since its proper divisors are 1, 2, 4, 7, 14 and the sum is 1 + 2 + 4 + 7 + 14 = 28

        isPerfectNumber(5); //should return false since its only proper divisor is 1 and the sum is 1 not 5

        isPerfectNumber(-1); //should return false since the number is < 1
        
    }
    public static boolean isPerfectNumber(int number){
        if (number < 1) return false;
        int sumFactors = 0;
        for (int i = 1; i < number; i++) 
            if (number % i == 0) sumFactors += i;
        return sumFactors == number;
    }
}
