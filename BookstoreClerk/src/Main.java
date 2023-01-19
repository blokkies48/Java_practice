import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Add initial data
        ConnectDatabase.addInitialBooks();

        // Running program
        ProgramLoop.mainLoop();

    }
}

