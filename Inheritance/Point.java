package Inheritance;

public class Point {
    private int x;
    private int y;

    public Point(){}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double distance() {
        double squareX = Math.pow(this.x, 2);
        double squareY = Math.pow(this.y, 2);
        return Math.sqrt(squareX + squareY);
    }
    public double distance(int x, int y) {
        double distanceX = Math.abs(x - this.x);
        double distanceY = Math.abs(y - this.y);
        double squareX = Math.pow(distanceX, 2);
        double squareY = Math.pow(distanceY, 2);
        return Math.sqrt(squareX + squareY);
    }
    public double distance(Point point){
        double distanceX = Math.abs(point.getX() - this.x);
        double distanceY = Math.abs(point.getY() - this.y);
        double squareX = Math.pow(distanceX, 2);
        double squareY = Math.pow(distanceY, 2);
        return Math.sqrt(squareX + squareY);
    }
}
