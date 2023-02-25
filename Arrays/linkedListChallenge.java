import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, int distance) {
}

public class linkedListChallenge {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String text = "Available actions (select word or letter):\n" +
                    "(F)orward\n" +
                    "(B)ackward\n" +
                    "(L)ist Places\n" +
                    "(M)enu\n" +
                    "(Q)uit";

            System.out.println(text);

            LinkedList<Place> towns = new LinkedList<>();

            addPlace(towns, new Place("Sydney", 0));
            addPlace(towns, new Place("Melbourne", 877));
            addPlace(towns, new Place("Perth", 3923));
            addPlace(towns, new Place("Adelaide", 1374));
            addPlace(towns, new Place("Darwin", 3972));
            addPlace(towns, new Place("Brisbane", 917));
            addPlace(towns, new Place("Alice Springs", 2771));

            sortList(towns);
            ListIterator<Place> iterTowns = towns.listIterator();
            boolean forward = true;
            boolean programOn = true;
            System.out.println("The starting city: " + towns.get(0));
            while (programOn) {
                String userChoice = scanner.nextLine().toUpperCase();
                switch (userChoice) {
                    case "F" -> {
                        if (forward) {
                            iterTowns.next();
                            forward = false;
                        }
                        if (iterTowns.hasNext()) {
                            System.out.println(iterTowns.next());
                        } else {
                            System.out.println("At the end boi!");
                        }
                    }
                    case "B" -> {
                        if (!forward) {
                            iterTowns.previous();
                            forward = true;
                        }
                        if (iterTowns.hasPrevious()) {
                            System.out.println(iterTowns.previous());
                        } else {
                            System.out.println("At the start boi!");
                        }
                    }
                    case "L" -> System.out.println(towns);
                    case "Q" -> programOn = false;
                }
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            return;
        }
        list.add(place);
    }

    private static void sortList(LinkedList<Place> list) {
        list.sort((p1, p2) -> p1.distance() - p2.distance());
    }

}
