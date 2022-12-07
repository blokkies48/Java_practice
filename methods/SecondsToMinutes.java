package methods;

public class SecondsToMinutes {
    public static void main(String[] args) {
       System.out.println(getDurationString(3945));
       System.out.println(getDurationString(-12113424));
       System.out.println(getDurationString(-1000,660));
       System.out.println(getDurationString(65,145));
        
    }
    public static String getDurationString(int seconds){

        if (seconds < 0){
            return "Invalid value entered.";
        }

        int secondsRemaining = seconds % 60;

        int minutes = (seconds / 60);
        int minutesRemaining = minutes % 60;

        int hours = seconds / 3600; 

        return (hours) + ":" + 
        String.format("%02d", minutesRemaining) + ":" + 
        String.format("%02d", secondsRemaining);
    }
    public static String getDurationString(int minutes, int seconds){
        if ( minutes < 0 || seconds < 0){
            return "Invalid value entered.";
        }
        return getDurationString((minutes * 60) + seconds);
    }

}
