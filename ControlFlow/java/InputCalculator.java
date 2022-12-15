package ControlFlow.java;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
        
    }
    public static void inputThenPrintSumAndAverage(){
        int sum = 0;
        int inputs = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true){
                try{
                    System.out.println("Enter a base 10 value or anything else to quit");
                    int userInput = Integer.parseInt(scanner.nextLine());
                    inputs ++;
                    sum += userInput;

                }catch (NumberFormatException e){
                    if (inputs == 0){
                        System.out.println("SUM = 0"  + " AVG = 0");
                    }else{
                        System.out.println("SUM = " + sum + " AVG = " + (sum/inputs));
                    }
                    break;
                }
            }
        }
    }
}
