package Inheritance;

public class ComplexNumber {
    private double realNumber;
    private double imaginaryNumber;

    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }
    public double getImaginaryNumber() {
        return imaginaryNumber;
    }
    public double getRealNumber() {
        return realNumber;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
