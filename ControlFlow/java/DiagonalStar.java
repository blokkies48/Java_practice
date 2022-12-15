package ControlFlow.java;

public class DiagonalStar {
    public static void main(String[] args) {
        printSquareStar(5);
        //*****
        //** **
        //* * *
        //** **
        //*****
        printSquareStar(8);
        printSquareStar(9);
        printSquareStar(-5);
        printSquareStar(2);
        
    }
    public static void printSquareStar(int number){
        if (number < 5){
            System.out.println("Invalid Value");
        }else{
            for (int row = 0; row < number; row++) {
                for (int column = 0; column < number; column++) {
                    if (row == 0  || row == number - 1){
                        System.out.print("*");
                    }
                    else if (column == 0 || column == number - 1){
                        System.out.print("*");
                    }
                    else if (column == row){
                        System.out.print("*");
                    }else if (column == number - (row + 1) ){ // row = 1 column = 3
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } 
    }
}
