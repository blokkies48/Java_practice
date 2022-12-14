package ControlFlow.java;

import java.time.Year;
import java.util.Scanner;

public class ScannerIn {
    public static void main(String[] args) {
        printAge();
    }

    public static void printAge(){
        Year currentYear = Year.now();
        int year = currentYear.getValue();
        //int currentYear = 2022;
        int age = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            do{
                try{
                    System.out.print("When where you born? ");
                    age = year - Integer.parseInt(scanner.nextLine());
                    if (age > 125 || age < 0) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number");
                }
            }while(true);
        }
        System.out.println("Your age is " + age);
    }
}
