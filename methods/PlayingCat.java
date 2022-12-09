package methods;

public class PlayingCat {
    public static void main(String[] args) {

        boolean a = isCatPlaying(true, 10); // should return false since temperature is not in range 25 - 45 

        boolean b = isCatPlaying(false, 36); // should return false since temperature is not in range 25 - 35 (summer parameter is false)

        boolean c = isCatPlaying(false, 35); // should return true since temperature is in range 25 - 35 
                

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (summer){
            return (temperature <= 45 && temperature >= 25);
        }
        return (temperature <= 35 && temperature >= 25);
        
    }
}
