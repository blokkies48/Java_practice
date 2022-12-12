package ControlFlow.java;

public class ForLoop1 {
    public static void main(String[] args) {
        for (double rate = 7.5; rate <= 10.0; rate+=0.25 ){
            System.out.println(calculateInterest(10000, rate));
        }

    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }
}
