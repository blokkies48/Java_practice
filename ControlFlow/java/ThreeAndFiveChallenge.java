package ControlFlow.java;

public class ThreeAndFiveChallenge {
    public static void main(String[] args) {
        System.out.println(sumOfThreeAndFive(1, 1000));
        
    }
    public static int sumOfThreeAndFive(int lowerRange, int upperRange){
        int sum = 0;
        int count = 1;

        for (int i = lowerRange; i <= upperRange && count <= 5; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)){
                System.out.println(i);
                sum+=i;
                count++;
            }
        }
        return sum;


    }
}
