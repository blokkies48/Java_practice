package ControlFlow.java;

import java.util.Scanner;

public class minMaxChallenge {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int min = 0;
            int max = 0;
            try{
                // Initial asking to set min max values
                System.out.print("Enter a number or any letter to stop: ");
                int number = Integer.parseInt(scanner.nextLine());
                min = number;
                max = number;
                // Continues ask for a number
                while (true){ 
                    try {
                        System.out.print("Enter a number or any letter to stop: ");
                        number = Integer.parseInt(scanner.nextLine());
                        if (number < min){
                            min = number;
                        }
                        else if (number > max){
                            max = number;
                        }
                    } catch (Exception e) {
                        break;
                    }        
                }
            }catch (Exception e) {
        }
        System.out.println("Min is: " + min);
        System.out.println("Max is: " + max);
        }
    }
}
