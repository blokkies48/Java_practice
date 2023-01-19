import java.sql.*;

// Static methods used to call on class object not instance.
class ConnectDatabase {

    // Static constant used in 2 methods
    private static final String addBookSQL = "INSERT INTO books (id, Title, Author, Qty) VALUES (?, ?, ?, ?)";

    public static Connection connectDatabase() {
        /**
         * connects to database
         * @return Connection
         * if unable to connect
         * @return null
         * */
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?allowPublicKeyRetrieval=true&useSSL=false",
                    "otheruser",
                    "swordfish"
            );

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void addInitialBooks() {
        /**
         * Initial adding of books on first run
         * This is required by the task.
         */

        try {
            Connection connection = connectDatabase();
            // Handle null exception
            if (connection != null) {
                // Variables
                Statement statement = connection.createStatement();
                PreparedStatement stmt = connection.prepareStatement(addBookSQL);
                // Initial data
                String[][] books = {
                        {"3001", "A Tale of Two Cities", "Charles Dickens", "30"},
                        {"3002", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "40"},
                        {"3003", "The Lion, the Witch and the Wardrobe", "C. S. Lewis", "25"},
                        {"3004", "The Lord of the Rings", "J.R.R Tolkien", "37"},
                        {"3005", "Alice in Wonderland", "Lewis Carroll", "12"},
                        {"3006", "Do Androids Dream of Electric Sheep?", "Philip K. Dick", "22"},
                };

                // Adding initial data
                for (String[] book : books) {
                    try {
                        stmt.setInt(1, Integer.parseInt(book[0]));
                        stmt.setString(2, book[1]);
                        stmt.setString(3, book[2]);
                        stmt.setInt(4, Integer.parseInt(book[3]));
                        stmt.executeUpdate();
                    } catch (NumberFormatException | SQLException ignored) {

                    }
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void enterBook(Book book) {
        /**
         * Add book object to database
         * @param Book object
         */

        try {
            // Establish connection
            Connection connection = connectDatabase();

            // Handle null exception
            if (connection != null) {
                PreparedStatement stmt = connection.prepareStatement(addBookSQL);
                Statement statement = connection.createStatement();
                ResultSet results;

                // Adding book
                // Using getter methods here
                try {
                    stmt.setInt(1, book.getId());
                    stmt.setString(2, book.getTitle());
                    stmt.setString(3, book.getAuthor());
                    stmt.setInt(4, book.getQty());
                    stmt.executeUpdate();
                } catch (NumberFormatException | SQLException e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void updateBook(int id, String title, String author)  {
        /**
         * If book updates author also has to.
         * ID is an identifier and shouldn't be updated.
         * @params int id
         * @params String title
         * @params String author
         * */
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeTitleAndAuthor =
                    "UPDATE books SET Title='"+ title +"', Author= '"+ author + "' WHERE id="+ id+ ";";

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQLCommandChangeTitleAndAuthor);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void updateBook(int id, int qty)  {
        /**
         * If book updates author also has to.
         * ID is an identifier and shouldn't be updated.
         * @params int id
         * @params int qty
         * */
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "UPDATE books SET Qty =" + qty +
                            " WHERE id="+ id+ ";";

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQLCommandChangeQty);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void deleteBook(int id){

        /**
         * Deletes book according to id
         * @params: int id
         * */
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "DELETE FROM books WHERE id="+ id+ ";";

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQLCommandChangeQty);
            }
        } catch (SQLException e) {
            System.out.println("Invalid Entry...");
        }
    }

    public static String searchBook(int id){
        /**
         * Search book
         * @params int id
         * @returns String
         * Remember to handle nullPointer exceptions
         * */
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "SELECT * FROM books WHERE id="+ id+ ";";
            // Return variable
            ResultSet results;

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQLCommandChangeQty);
                while (results.next()){
                    return "ID: "+ results.getInt("Id")+
                            "\nTitle: " + results.getString("title") +
                            "\nAuthor: " + results.getString("Author") +
                            "\nQty: " + results.getInt("Qty");
                }
            }else{
                throw new SQLException();
            }

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        // Make java happy, but not needed this code will never be run.
        return null;
    }
    public static void displayAllBooks(){
        /**
         * Displays all rows in the table
         * */
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "SELECT * FROM books;";
            // Return variable
            ResultSet results;

            // Handle null exception
            if (connection != null) {

                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQLCommandChangeQty);
                int count = 0;
                while (results.next()){
                    count ++;
                    System.out.println("---Item "+ count + "---");
                    System.out.println(
                        "ID: "+ results.getInt("Id")+
                        " Title: " + results.getString("title") +
                        " Author: " + results.getString("Author") +
                        " Qty: " + results.getInt("Qty") + "\n------------"
                    );
                }
            }else{
                throw new SQLException();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
