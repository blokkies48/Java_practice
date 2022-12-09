package ControlFlow;

public class NumberOfDaysInMonths {
    public static void main(String[] args) {
        boolean a = isLeapYear(-1600);// →  should return false since the parameter is not in the range (1-9999)

        boolean b = isLeapYear(1600);// → should return true since 1600 is a leap year

        boolean c = isLeapYear(2017);// → should return false since 2017 is not a leap year

        boolean d = isLeapYear(2000);// → should return true because 2000 is a leap year 
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        int e = getDaysInMonth(1, 2020);// → should return 31 since January has 31 days.

        int f = getDaysInMonth(2, 2020);// → should return 29 since February has 29 days in a leap year and 2020 is a leap year.

        int g = getDaysInMonth(2, 2018);// → should return 28 since February has 28 days if it's not a leap year and 2018 is not a leap year.

        int h = getDaysInMonth(-1, 2020); //→ should return -1 since the parameter month is invalid.

        int i = getDaysInMonth(1, -2020); //→ should return -1 since the parameter year is outside the range of 1 to 9999.

        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);


    }
    public static boolean isLeapYear(int year) {
    
        if (year < 0 || year > 9999){
            return false;
        }
        if (year % 4 == 0 ){
            return true;
        }else{
            if (year % 100 == 0){
                return true;
            }else if (year % 400 == 0){
                return true;
            }
        return false;
        }
    }
    public static int getDaysInMonth(int month, int year){
        int daysOfMonth = 0;
        if (month < 1 || month > 12 || year < 1 || year > 9999){
            return -1;
        }
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> daysOfMonth = 31;
            case 4, 6, 9, 11 -> daysOfMonth = 30;
            case 2 -> daysOfMonth = 28;
            default -> daysOfMonth = -1;
        }
        if (month == 2 && isLeapYear(year)){
            daysOfMonth ++;
        }
        return daysOfMonth;
    }
}
