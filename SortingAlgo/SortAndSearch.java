public class SortAndSearch {
    // Linear search will be appropriate because the array isn't long and it's not sorted.
    public static void main(String[] args) {
        int[] intArray = {27, -3, 4, 5, 35, 2, 1, -40, 7, 18, 9, -1, 16, 100};
        int target = 9;

        // Searching through the unsorted array to get 9's index
        int targetIndex = linearSearch(intArray, target);
        System.out.println("\nUnsorted array index of 9");
        System.out.println(targetIndex);

        // Sorting array using insertion sort.
        insertionSort(intArray);
        System.out.println("\nSorted array using insertion sort");
        for (int value : intArray) {
            System.out.print(value + ", ");
        }

        // Finding index of nine using binary search of sorted array
        binarySearch(intArray, 9);
        System.out.println("\n\nIndex of nine in sorted array");
        System.out.println(binarySearch(intArray, target));
        // Where you would use binary search in the real world.
        // One example where I personally have used binary search is:
        // Searching through user id numbers, because id numbers tend to be sorted and users lists tend to be large
        // Imagine using linear search to search through 10 million users and you want the 9,999,999 users
        // Binary search is perfect in this case.
    }
    // Simple linear search
    private static int linearSearch(int[] intArray, int target){
        int index = -1;
        for (int i = 0; i < intArray.length; i++){
            if (intArray[i] == target){
                index = i;
                break;
            }
        }

        return index;
    }
    // https://www.youtube.com/watch?v=0lOnnd50cGI
    private static void insertionSort(int[] intArray){
        for (int i = 1; i < intArray.length; i++){
            int temp = intArray[i];
            int j = i - 1;
            // Looping backwards
            while (j >= 0 && intArray[j] > temp){
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = temp;
        }       
    }
    // Binary search
    private static int binarySearch(int[] intArray, int target){
        int low = 0;
        int high = intArray.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if (intArray[mid] == target){
                return mid;
            }
            else if (intArray[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }       
}
