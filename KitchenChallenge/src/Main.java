import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        SmartKitchen smartKitchen = new SmartKitchen();

        smartKitchen.doKitchenWork("fridge");
        smartKitchen.doKitchenWork("coffee");
    }
}

class SmartKitchen{
    private final CoffeeMaker coffeeMaker;
    private final DishWasher dishwasher;
    private final Refrigerator fridge;

    public SmartKitchen() {
        this.coffeeMaker = new CoffeeMaker();
        this.dishwasher = new DishWasher();
        this.fridge = new Refrigerator();
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }
    public DishWasher getDishwasher() {
        return dishwasher;
    }
    public Refrigerator getFridge() {
        return fridge;
    }
    
    public void doKitchenWork(String item){
        if (Objects.equals(item, "coffee")){
            getCoffeeMaker().addWater();
            getCoffeeMaker().brewCoffee();
        } else if (Objects.equals(item, "fridge")) {
            getFridge().pourMilk();
            getFridge().orderFood();
        } else if (Objects.equals(item, "dishes")) {
            getDishwasher().loadDishwasher();
            getDishwasher().doDishes();
        }
    }
}

class Refrigerator{
    private boolean hasWorkToDo = false;

    public void pourMilk(){
        hasWorkToDo = true;
    }

    public void orderFood(){
        if (hasWorkToDo){
            System.out.println("Ordering food...");
            hasWorkToDo = false;
        }
    }
}

class DishWasher{
    private boolean hasWorkToDo = false;

    public void loadDishwasher(){hasWorkToDo = true;}

    public void doDishes(){
        if (hasWorkToDo) {
            System.out.println("Doing dishes...");
            hasWorkToDo = false;
        }
    }
}

class CoffeeMaker{
    private boolean hasWorkToDo = false;

    public void addWater(){
        this.hasWorkToDo = true;
    }

    public void brewCoffee(){
        if (this.hasWorkToDo) {
            System.out.println("Brewing motherfing coffee...");
        }
    }
}
