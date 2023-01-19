import java.util.Objects;
import java.util.Scanner;

class ProgramLoop {
    static void mainLoop() {
        /**
         * Program main loop and UI
         * */
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Start UI
            System.out.println("--------------\n" +
                    "1. Enter book\n" +
                    "2. Update book\n" +
                    "3. Delete book\n" +
                    "4. Search book\n" +
                    "5. Display content\n" +
                    "0. Exit\n" +
                    "--------------");
            System.out.print("Make your selection: ");
            String selection = scanner.nextLine();
            System.out.println("--------------");
            // End UI

            // Add book
            if (Objects.equals(selection, "1")) {

                newBookEntryUI();

            }
            // Update book
            else if (Objects.equals(selection, "2")) {

                updateBook();

            }
            // Delete book
            else if (Objects.equals(selection, "3")) {

                deleteBook();

            }
            // Search book
            else if (Objects.equals(selection, "4")) {
                searchBook();
            }
            // Show all items in the table
            else if (Objects.equals(selection, "5")) {
                ConnectDatabase.displayAllBooks();
            } else if (Objects.equals(selection, "0")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Selection");
            }
        }
    }

    public static void newBookEntryUI() {
        Scanner scanner = new Scanner(System.in);

        // UI to get book values
        System.out.println("Add New Book\n--------------");

        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        System.out.print("Enter book title: ");
        scanner.nextLine(); // Consume previous line
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // Consume previous line

        // Creating book object and passing values
        Book book = new Book(id, title, author, qty);

        // Calling static method and passing book object
        ConnectDatabase.enterBook(book);

    }

    public static void updateBook() {
        /**
         * updates book depending on choice.
         * */
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "Change \n" +
                    "1. Tile & Author\n" +
                    "2. Quantity\n" +
                    "3. Display all books\n" +
                    "4. Back");

            String selection = scanner.nextLine();

            // Catching exceptions that can be string input
            try{

                // Update title and author
                if (Objects.equals(selection, "1")) {

                    System.out.print("Please enter a Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume previous line

                    // Check if book exists
                    if (ConnectDatabase.searchBook(id) != null){
                        // Get user inputs
                        System.out.println("-----------");
                        System.out.print("Please enter a new title: ");
                        String title = scanner.nextLine();
                        System.out.println("-----------");
                        System.out.print("Please enter a new author: ");
                        String author = scanner.nextLine();
                        System.out.println("-----------");

                        ConnectDatabase.updateBook(id, title, author);
                    }
                    // If book does not exist
                    else{
                        System.out.println("Book doesn't exist...");
                    }

                // Update quantity
                } else if (Objects.equals(selection, "2")) {

                    // Getting user input
                    System.out.print("Please enter a Id: ");
                    int id = scanner.nextInt();

                    // Check if book exists
                    if (ConnectDatabase.searchBook(id) != null){
                        System.out.println("-----------");
                        System.out.print("Please enter a new quantity: ");
                        int qty = scanner.nextInt();
                        ConnectDatabase.updateBook(id, qty);
                    }
                    // If book does not exist
                    else{
                        System.out.println("Book doesn't exist...");
                    }

                }
                else if (Objects.equals(selection, "3")) {
                    ConnectDatabase.displayAllBooks();
                }
                else if (Objects.equals(selection, "4")) {
                    break;
                } else {
                    System.out.println("Invalid selection.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection");
            }
        }
    }

    public static void deleteBook() {
        // defensive programming
        while (true){
            try {
                // Deleting book
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the id of the book you want to delete or -1 to cancel: ");
                int id = scanner.nextInt();
                // checks if book actually exists
                if (ConnectDatabase.searchBook(id) != null){
                    ConnectDatabase.deleteBook(id);
                    System.out.println("Deleting book...");
                    System.out.println("Book deleted");
                    break;

                } else if (id == -1) { // Cancel operation
                    break;
                } else {
                    System.out.println("Book doesn't exist...");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection...");
            }
        }
    }

    public static void searchBook() {
        // defensive programming
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the id of the book you want to search: ");
                int id = scanner.nextInt();
                String book = ConnectDatabase.searchBook(id);
                if (book != null){
                    System.out.println("----your book----");
                    System.out.println(book);
                    System.out.println("-----------------");
                }
                else {
                    System.out.println("-----------\nBook not found\n-----------");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid selection...");
            }

        }
    }
}
