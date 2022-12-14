package ControlFlow.java;

public class NumberToWords {
    public static void main(String[] args) {
        getDigitCount(0); //should return 1 since there is only 1 digit

        getDigitCount(123); //should return 3

        getDigitCount(-12); //should return -1 since the parameter is negative

        getDigitCount(5200); //should return 4 since there are 4 digits in the number

        reverse(-121); //should  return -121

        reverse(1212); //should return  2121

        reverse(1234); //should return 4321

        reverse(100); //should return 1

        numberToWords(123); //should print "One Two Three".

        numberToWords(1010); //should print "One Zero One Zero".

        numberToWords(1000);// should print "One Zero Zero Zero".

        numberToWords(-12); //should print "Invalid Value" since the parameter is negative.
                
    }
    public static void numberToWords(int number){
        if (number < 0){
            System.out.println("Invalid Value");
        }
        int value = reverse(number);
        for (int i = 0; i < getDigitCount(number); i++) {
            switch (value % 10) {
                case 0:
                    System.out.print("Zero ");
                    break;
                case 1:
                    System.out.print("One ");
                    break;
                case 2:
                    System.out.print("Two ");
                    break;
                case 3:
                    System.out.print("Three ");
                    break;
                case 4:
                    System.out.print("Four ");
                    break;
                case 5:
                    System.out.print("Five ");
                    break;
                case 6:
                    System.out.print("Six ");
                    break;
                case 7:
                    System.out.print("Seven ");
                    break;
                case 8:
                    System.out.print("Eight ");
                    break;
                case 9:
                    System.out.print("Nine ");
                    break;
                default:
                    System.out.println("Invalid Value");
                    break;
            } 
            value /= 10;
        }
        System.out.println();
    }
    public static int reverse(int number){
        int returnValue = 0;
        int bufferNum = number;

        if (number < 0){
            bufferNum = -(bufferNum);
        }
        while (bufferNum > 0){
            returnValue *= 10;
            returnValue += bufferNum % 10;
            bufferNum /= 10;
        }
        if (number < 0){
            returnValue = -(returnValue);
        }
        return returnValue;
    }

    public static int getDigitCount(int number){
        if (number < 0){
            return -1;
        }
        
        int lenOfNumber = 0;
        if (number == 0){
            return lenOfNumber + 1;
        }
        while (number > 0){
            lenOfNumber ++;
            number /= 10;
        }
        return lenOfNumber;
    }
}
