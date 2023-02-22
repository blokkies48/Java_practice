package Arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChallengeOne {
    public static void main(String[] args) {
        int[] userArray = readIntegers();
        System.out.println("The array is: " + Arrays.toString(userArray));
        System.out.println("The min value in the array is: " + minIntValue(userArray));
        reverseArray(userArray); // Reverses array in place
        System.out.println("The array in reverse is: " + Arrays.toString(userArray));
    }

    private static int[] readIntegers() {
        int arrayLength = 0;
        int[] intArray = new int[arrayLength];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please enter the length of your array: ");
                arrayLength = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // clear input buffer
                System.out.println("Enter a valid integer!!!");
            }
        }
        if (arrayLength > 0) {
            intArray = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                while (true) {
                    try {
                        System.out.print("Enter int number " + (i + 1) + ": ");
                        intArray[i] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // clear input buffer
                        System.out.println("Enter a valid integer at " + (i + 1) + "!!!");
                    }
                }
            }
        }
        scanner.close();
        return intArray;
    }

    private static int minIntValue(int[] intArray) {
        int minValue = intArray[0];
        for (int value : intArray) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    private static void reverseArray(int[] intArray) {
        int temp;
        for (int i = 0; i < intArray.length / 2; i++) {
            temp = intArray[i];
            intArray[i] = intArray[intArray.length - 1 - i];
            intArray[intArray.length - 1 - i] = temp;
        }
    }
}