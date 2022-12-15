package ControlFlow.java;

import java.util.Scanner;

public class UserInputChallenge {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int maxInput = 5;
            double sumNumber = 0;
            for (int i = 1; i <= maxInput; i++) {
                do{
                    try {
                        System.out.print("Enter number #" + i + ": ");
                        sumNumber += Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Value");
                    }
                }while (true);
            }
            System.out.println(sumNumber);
        }
    }
}
