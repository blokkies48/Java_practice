import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ConnectToDatabase {

    private final static String warningMessage = "WARNING - ID already in use try again.";
    public static Connection connectDatabase() {
        /**
         * connects to database
         * @return Connection
         * if unable to connect
         * @return null
         * */
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms?allowPublicKeyRetrieval=true&useSSL=false",
                    "otheruser",
                    "swordfish"
            );

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Adds record to table
     * @param id of customer
     * @param name of customer
     * */
    public static void addToTable(int id, String name, String tableName){
        try{
            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "INSERT INTO "+ tableName + " VALUES ( " + id + ", '" + name + "');";

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQLCommandChangeQty);
            }
        } catch (SQLException e) {
            System.out.println(warningMessage);
        }

    }
    /**
     * @param tableName to print from
     * Prints all contents of the table name passed
     */
    public static void printAllTable(String tableName){
        try{

            Connection connection = connectDatabase();
            String SQLQuery = "SELECT * FROM " + tableName + ";";

            ResultSet results;

            if (connection != null){
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQLQuery);
                System.out.println("\n----------\n***" + tableName + "***\n----------");
                int count = 1;
                while (results.next()){
                    System.out.println("----------");
                    System.out.println( tableName + "-- " + count);
                    System.out.println("ID: " + results.getInt("id"));
                    System.out.println("Name: " + results.getString("name"));
                    count ++;
                }
                System.out.println("----------\n*** End ***\n----------");
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }


    /**
     * @param id add the id of the project
     * Asks the user for all ids and descriptions then adds -
     * recode to projects table.
     * */
    public static void addProject(int id){
        try{
            Scanner scanner = new Scanner(System.in);

            int engineerId;
            int managerId;
            int architectId;
            int customerId;
            String shortDesc;
            byte finalised;
            String start_date;
            String due_date;
            String completed_date;

            // Get engineer id
            printAllTable("engineer");
            System.out.print("Select an engineer ID: ");
            engineerId = scanner.nextInt();

            // Get manager id
            printAllTable("project_manager");
            System.out.print("Select an manager ID: ");
            managerId = scanner.nextInt();

            // Get architect id
            printAllTable("architect");
            System.out.print("Select an architect ID: ");
            architectId = scanner.nextInt();

            // Get architect id
            printAllTable("customer");
            System.out.print("Select an customer ID: ");
            customerId = scanner.nextInt();
            scanner.nextLine(); // Consume previous line

            // Get short description
            System.out.println("Enter a short description: ");
            shortDesc = scanner.nextLine();

            // Is finalized set to 0 when created
            finalised = 0;

            // Initialized date
            start_date = String.valueOf(LocalDate.now());

            // Get due date
            System.out.print("Set the due date 0000-00-00: ");
            due_date = scanner.nextLine();

            // Set completed date
            completed_date = "0000-00-00";

            // Establish connection
            Connection connection = connectDatabase();
            // SQL commands
            String SQLCommandChangeQty =
                    "INSERT INTO projects VALUES ( "
                            + id +
                            ", " + engineerId +
                            ", " + managerId +
                            ", " + architectId +
                            ", " + customerId +
                            ", '" + shortDesc +
                            "', " + finalised +
                            ", '" + start_date +
                            "', '" + due_date +
                            "', '" + completed_date +
                            "');";

            // Handle null exception
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQLCommandChangeQty);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * Print all the projects in projects table
     * */
    public static void printAllProjects() {
        try {

            Connection connection = connectDatabase();
            String SQL = "SELECT * FROM projects";

            ResultSet results;

            if (connection != null) {
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQL);


                int count = 1;
                System.out.println("\n----------\n*** Projects ***\n----------");
                while (results.next()){
                    String finalised = Objects.equals(results.getInt(7), 0)  ? "Not Finalised" : "Is Finalised";

                    System.out.println("\n----------\nProject Number " + count + "\n----------");
                    System.out.println("Project ID: " + results.getInt(1));
                    System.out.println("Engineer ID: " + results.getInt(2));
                    System.out.println("Manager ID: " + results.getInt(3));
                    System.out.println("Architect ID: " + results.getInt(4));
                    System.out.println("Customer ID: " + results.getInt(5));
                    System.out.println("Short Desc: " + results.getString(6));
                    System.out.println("Is finalised: " + (finalised));
                    System.out.println("Start Date ID: " + results.getString(8));
                    System.out.println("Due Date: " + results.getString(9));
                    System.out.println("Completed Date: " + results.getString(10));
                }
                System.out.println("----------\n*** End ***\n----------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes form table according to table passed and id
     * @param ID of record to delete
     * @param tableName of table to delete from
     * */
    public static void deleteFromTable(String tableName, int ID){
        try{
            String SQL = "DELETE FROM " + tableName + " WHERE id=" + ID + ";";
            Connection connection = connectDatabase();
            if (connection != null){
                Statement statement = connection.createStatement();
                statement.executeUpdate(SQL);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * Update info about a project
     * Depends on user selection
     * @param id of project record to update
     *
     * */
    public static void updateProjectInfo(int id){
        try{
            //
            Scanner scanner = new Scanner(System.in);
            Connection connection = connectDatabase();
            ResultSet resultSet;
            System.out.println("What do you want to update?\n" +
                    "1. Engineer ID\n" +
                    "2. Manager ID\n" +
                    "3. Architect ID\n" +
                    "4. Customer ID\n" +
                    "5. Short Description\n" +
                    "6. Finalise\n" +
                    "7. Due date");

            int userSelection = scanner.nextInt();

            if (Objects.equals(userSelection, 1)){
                System.out.print("Please enter the new value: ");
                int newValue = scanner.nextInt();
                String SQL = "Update projects set engineer_id = "+ newValue+" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 2)){
                System.out.print("Please enter the new value: ");
                int newValue = scanner.nextInt();
                String SQL = "Update projects set manager_id = "+ newValue+" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 3)){
                System.out.print("Please enter the new value: ");
                int newValue = scanner.nextInt();
                String SQL = "Update projects set architect_id = "+ newValue+" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 4)){
                System.out.print("Please enter the new value: ");
                int newValue = scanner.nextInt();
                String SQL = "Update projects set customer_id = "+ newValue+" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 5)){
                System.out.print("Please enter the new value: ");
                String newValue = scanner.nextLine();
                String SQL = "Update projects set short_desc = "+ newValue +" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 6)){
                String todayDate = String.valueOf(LocalDate.now());
                System.out.println(todayDate);
                String SQL = "Update projects set is_finalized = "+ 1 + "," +
                        " end_date = '"+ todayDate +"' where id = " + id +";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }
            else if (Objects.equals(userSelection, 7)){
                System.out.print("Please enter the new date 0000-00-00: ");
                String newValue = scanner.nextLine();
                String SQL = "Update projects set short_desc = "+ newValue +" where id = " + id + ";";
                if (connection != null){
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQL);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//TODO: REMOVE
//create table project (id int primary key, engineer_id int, manager_id int, architect_id int, customer_id int, short_desc varchar(500), is_finalized int, start_date varchar(50), due_date varchar(50),  end_date varchar(50));
