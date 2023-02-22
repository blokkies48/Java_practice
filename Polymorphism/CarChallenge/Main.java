package Polymorphism.CarChallenge;

public class Main {
    

    public static void main(String[] args) {
        GasPoweredCar car = new GasPoweredCar("Ford", "Focus", 20, 200);
        car.drive()
    }

    
    
}

class Car{

    private String name;
    private String model;
    private int acceleration;
    private int topSpeed;
    private String fuelType;

    public Car(String name, String model, int acceleration, int topSpeed, String fuelType) {
        this.name = name;
        this.model = model;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.fuelType = fuelType;
    }

    public void startEngine(){
        System.out.println(this.name + " Uses " + this.fuelType + " to start.");
    }

    public double drive(){
        return topSpeed / acceleration;
    }

    protected void runEngine(){
        System.out.println(this.model +  " Uses " + this.fuelType + " to run the engine.");
    }
}

class GasPoweredCar extends Car {

    public GasPoweredCar(String name, String model, int acceleration, int topSpeed) {
        super(name, model, acceleration, topSpeed, "gas");
    }
    public void p(){
        System.out.println("poop");
    }
}

