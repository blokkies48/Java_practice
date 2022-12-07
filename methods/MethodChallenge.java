package methods;

public class MethodChallenge {
    public static void main(String[] args) {
        System.out.println(hasTeen(9,99,19));
        System.out.println(hasTeen(23,15,42));
        System.out.println(hasTeen(22,23,34));
    }
    public static boolean hasTeen(int age1, int age2, int age3){
        int[] ages = {age1, age2, age3};

        for (int age: ages) {
            if (age > 12 && age < 20)
                return true;
        }
        return false;
    }

}
