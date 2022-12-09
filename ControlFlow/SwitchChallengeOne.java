package ControlFlow;

public class SwitchChallengeOne {
    public static void main(String[] args) {
        System.out.println(phoneticAlphabet('A'));
        System.out.println(phoneticAlphabet('E'));

        printDayOfWeek(4);
    }
    public static String phoneticAlphabet(char character) {
        
        switch (character) {
            case 'A':
                return "Able";
            case 'B':
                return "Baker";
            case 'C':
                return "Charlie";
            case 'D':
                return "Dog";
            case 'E':
                return "Easy";
            default:
                return "Nothing found";
        }
    
    }

    public static void printDayOfWeek(int dayOfWeek) {
        switch (dayOfWeek){
            case 1 -> {System.out.println("Monday");}
            case 2 -> {System.out.println("Tuesday");}
            case 3 -> {System.out.println("Wednesday");}
            case 4 -> {System.out.println("Thursday");}
            case 5 -> {System.out.println("Friday");}
            case 6 -> {System.out.println("Saturday");}
            case 7 -> {System.out.println("Sunday");}
            default -> {System.out.println("No day found");}
        }
    }
    
}
