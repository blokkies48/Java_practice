import java.util.*;

public class challengeArrayList {
    public static void main(String[] args) {
        ArrayList<String> groceriesList = new ArrayList<>();

        while (true) {
            int userSelection = getMenuInput();
            if (userSelection == 0) {
                break;
            } else if (userSelection == 1) {
                addItemToList(groceriesList);
            } else if (userSelection == 2) {
                removeItem(groceriesList);
            }
        }
    }

    private static int getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (true) {
            try {
                System.out.println("Available Actions:\n" +
                        "0 - Exit\n" +
                        "1 - to add item(s) to list (comma delimited list)\n" +
                        "2 - to remove any items (comma delimited list)\n" +
                        "Enter the number for which action you want to do: ");
                userInput = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input: " + e);
            }
        }
        return userInput;
    }

    private static void addItemToList(ArrayList<String> theList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values then separate them using a ',': ");
        String newValues = scanner.nextLine();
        for (String element : newValues.split(",")) {
            if (element.contains(" ")) {
                element = element.replaceAll(" ", "");
            }
            if (theList.contains(element)) {
                continue;
            }
            theList.add(element.toLowerCase());
        }
        printSortedList(theList);
    }

    private static void removeItem(ArrayList<String> theList) {
        int indexToDlt;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the index of the element you want to delete: ");
                indexToDlt = scanner.nextInt();
                if (indexToDlt >= theList.size()) {
                    System.out.println("Index out of range:");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input..." + e);
            }
        }
        theList.remove(indexToDlt);
        printSortedList(theList);
    }

    private static void printSortedList(ArrayList<String> theList) {

        Collections.sort(theList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        System.out.println(theList);
    }
}