package ControlFlow.java;

public class FlourPackProblem {
    public static void main(String[] args) {

        boolean a = canPack (1, 0, 4);// should return false since bigCount is 1 (big bag of 5 kilos) and goal is 4 kilos.

        boolean b = canPack (1, 0, 5); //should return true since bigCount is 1 (big bag of 5 kilos) and goal is 5 kilos.

        boolean c = canPack (0, 5, 4); //should return true since smallCount is 5 (small bags of 1 kilo) and goal is 4 kilos, and we have 1 bag left which is ok as mentioned above.

        boolean d = canPack (2, 2, 11); //should return true since bigCount is 2 (big bags 5 kilos each) and smallCount is 2 (small bags of 1 kilo), makes in total 12 kilos and goal is 11 kilos. 

        boolean e = canPack (-3, 2, 12); //should return false since bigCount is negative.
        
        System.out.println(a); //false
        System.out.println(b); //true
        System.out.println(c); //true
        System.out.println(d); //true
        System.out.println(e); //false

        System.out.println(canPack(2, 1, 5)); // true
        System.out.println(canPack(4, 18, 19)); // true
        System.out.println(canPack(5, 3, 24)); // false
        System.out.println(canPack(6, 2, 17)); // true

    }
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;
        // Weight in kg
        int weightBig = 5 * bigCount;
        int sumWeight = weightBig + smallCount;
        if (weightBig == goal){
            return true;
        }
        else if (sumWeight >= goal){
            if (weightBig > goal){
                int remainder = goal % 5;
                if (remainder > smallCount){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
