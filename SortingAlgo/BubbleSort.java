import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<String> array =  new ArrayList<>(Arrays.asList(
        "blue", "six", "hello", "game", "unorthodox", "referee", "ask", "zebra", "run", "flex"
        ));
        // Unsorted array
        System.out.println("\nUnsorted array");
        System.out.println(array);
        // Sorted according to length
        System.out.println("\nSorted according to length of strings");
        bubbleSortStringLength(array);
        System.out.println(array);
        // Sorted alphabetically
        System.out.println("\nSorted alphabetically");
        bubbleSortStringAlpha(array);
        System.out.println(array);
    }

    // Sorting string arraylist ascending order by length of string 
    public static void bubbleSortStringLength(ArrayList<String> array){
        for (int i = (array.size() - 1);i >= 0; i--) 
        {
            for (int j = 1; j <= i; j++) 
            {
                if (array.get(j - 1).length() > array.get(j).length())
                {
                    String temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }
    // Sorting string list alphabetically
    public static void bubbleSortStringAlpha(ArrayList<String> array){
        for (int i = (array.size() - 1);i >= 0; i--) 
        {
            for (int j = 1; j <= i; j++) 
            {
                if (array.get(j - 1).compareTo(array.get(j)) > 0) // Only difference
                {
                    String temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }
}


