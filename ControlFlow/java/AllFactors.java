package ControlFlow.java;

public class AllFactors {
    public static void main(String[] args) {
        printFactors(6);// → should print 1 2 3 6

        printFactors(32);// → should print 1 2 4 8 16 32

        printFactors(10);// → should print 1 2 5 10

        printFactors(-1);// → should print "Invalid Value" since number is < 1
    }


    public static void printFactors(int number) {
        if (number < 1){
            System.out.println("Invalid Value");
        }
        for (int i = 1; i < number + 1; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();    
    }
}
