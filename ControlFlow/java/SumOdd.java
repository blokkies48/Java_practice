package ControlFlow.java;

public class SumOdd {
    public static void main(String[] args) {
        System.out.println(isOdd(99));
        System.out.println(isOdd(88));



        int a = sumOdd(1, 100); //→ should return 2500

        int b = sumOdd(-1, 100); //→ should return -1       

        int c = sumOdd(100, 100); //→ should return 0

        int d = sumOdd(13, 13); //→ should return 13 (This set contains one number, 13, and it is odd)

        int e = sumOdd(100, -100); //→ should return -1

        int f = sumOdd(100, 1000); //→ should return 247500

        System.out.println(sumOdd(10, 5));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        }

    public static boolean isOdd(int number){
        if (number < 0) {
            return false;
        }
        else{
            if (!(number % 2 == 0)){
                return true;
            }
        }
        return false;
    }

    public static int sumOdd(int lowerRange, int upperRange){
        int returnSum = 0;

        if (lowerRange < 0 || upperRange < 0 || (upperRange - lowerRange < 0)) {
            return -1;
        }

        for (int i = lowerRange; i <= upperRange; i++) {
            if (isOdd(i)){
                returnSum += i;
            }
        }
        return returnSum;
    }
}
