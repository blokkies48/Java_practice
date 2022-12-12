package ControlFlow.java;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(8));
        System.out.println(isPrime(2));
        System.out.println(isPrime(6));
        System.out.println(isPrime(97));
        System.out.println(isPrime(0));
        System.out.println(isPrime(100));
        System.out.println(isPrime(17));

        System.out.println(totalPrimes(1000));
        
        
    }
    public static boolean isPrime(int wholeNumber){
        if (wholeNumber <= 2){
            return (wholeNumber == 2);
        }
        for (int divisor = 2; divisor <= wholeNumber / 2; divisor ++){
            if (wholeNumber % divisor == 0){
                return false;
            }
        }
        return true;
        
    }
    public static int totalPrimes(int range){
        int foundPrimes = 0;

        for (int i = 2; i <= range; i++) {
            if (isPrime(i)){
                foundPrimes ++;
            }
            if (foundPrimes == 3){
                break;
            }
        }
        return foundPrimes;
        
    }
}
