import java.sql.*;

// Static methods used to call on class object not instance.
class ConnectDatabase {

    private static final String addBookSQL = "INSERT INTO books (id, Title, Author, Qty) VALUES (?, ?, ?, ?)";

    public static Connection connectDatabase() {
        /**
         * connects to database
         * @return Connection
         * if unable to connect
         * @return null
         * */
        try {
            // Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
            // Use username "otheruser", password "swordfish".

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
                    } catch (NumberFormatException | SQLException e) {
                        System.out.println(e);
                    }
                }

                // TODO: REMOVE
                ResultSet results;

                results = statement.executeQuery("SELECT title, qty FROM books");
                while (results.next()) {
                    System.out.println(results.getString("title") + ", " + results.getInt("qty"));
                }
                // TODO: END REMOVE
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

            // If not null
            if (connection != null) {
                PreparedStatement stmt = connection.prepareStatement(addBookSQL);
                Statement statement = connection.createStatement();
                ResultSet results;

                // Adding book
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
    public static void updateBook(){

    }
}
