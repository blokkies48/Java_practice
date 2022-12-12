package ControlFlow.java;

public class WhileLoop {
    public static void main(String[] args) {
        int i = 5;
        int evenNumbers = 0;
        int oddNumbers = 0;
        while (i <= 20) {
            if (evenNumbers == 5){
                System.out.println("Even numbers = "+ evenNumbers);
                System.out.println("Odd numbers = "+ oddNumbers);
                break;
            }

            if (isEvenNumber(i)){
                evenNumbers ++;
                System.out.println(i);
            } 
            else{
                oddNumbers++;
            }
            i++;
            
        }
        
    }
    public static boolean isEvenNumber(int number){
        return number % 2 == 0;
    }

}
