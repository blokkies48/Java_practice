package ControlFlow.java;

public class LargestPrime {
    public static void main(String[] args) {
        int a = getLargestPrime (21); //should return 7 since 7 is the largest prime (3 * 7 = 21)

        int b = getLargestPrime (217); //should return 31 since 31 is the largest prime (7 * 31 = 217)

        int c = getLargestPrime (0);// should return -1 since 0 does not have any prime numbers

        int d = getLargestPrime (45); //should return 5 since 5 is the largest prime (3 * 3 * 5 = 45)

        int e = getLargestPrime (-1); //should return -1 since the parameter is negative

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println(getLargestPrime(7)); // 7
        System.out.println(getLargestPrime(2)); // 2

    }
    public static int getLargestPrime(int number){
        if (number <= 1) return -1;
        int prime = 0;
        boolean isPrime = false;
        int p = 0;
        
        for (int i = 1; i < number; i++){
            if (number % i == 0 && !isPrime){
                p++;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0){
                        isPrime = true;
                    }
                }
                if (!isPrime){
                    prime = i;
                    isPrime = false;
                }
            }
        }
        if (p == 1){
            return number;
        }
        return prime;
    }
}
