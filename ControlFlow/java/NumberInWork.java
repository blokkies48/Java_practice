package ControlFlow.java;

public class NumberInWork {
    public static void main(String[] args) {
        printNumberInWord(0);
        printNumberInWord(1);
        printNumberInWord(2);
        printNumberInWord(3);
        
    }
    public static void printNumberInWord(int wholeNumber){
        String word;
        switch (wholeNumber){
            case 0 -> word = "ZERO";
            case 1 -> word = "ONE";
            case 2 -> word = "TWO";
            case 3 -> word = "THREE";
            case 4 -> word = "FOUR";
            case 5 -> word = "FIVE";
            case 6 -> word = "SIX";
            case 7 -> word = "SEVEN";
            case 8 -> word = "EIGHT";
            case 9 -> word = "NINE";
            default -> word = "OTHER";
        }
        switch (wholeNumber) {
            case 0:
                word = "ZERO";
                break;
            case 1:
                word = "ONE";
                break;
            case 2:
                word = "TWO";
                break;
            case 3:
                word = "THREE";
                break;
            case 4:
                word = "FOUR";
                break;
            case 5:
                word = "FIVE";
                break;
            case 6:
                word = "SIX";
                break;
            case 7:
                word = "SEVEN";
                break;
            case 8:
                word = "EIGHT";
                break;
            case 9:
                word = "NINE";
                break;
            
            default:
                word = "OTHER";
                break;
        }
        System.out.println(word); 
    }
}
