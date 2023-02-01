import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
/**
 * Class is used to do all the changes to the database
 * @author Jonathan
 * */
public class ConnectToDatabase {

    private final static String warningMessage = "WARNING - ID already in use try again.";
    /**
     * connects to database then returns connection
     * null is returned when connection fails
     * @return Connection or null
     * */
    public static Connection connectDatabase() {

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
     * */
    public static void addToTable(String tableName){
        try{
            while (true){

                Scanner scanner = new Scanner(System.in);
                // Enter id and name
                System.out.println("Please enter the id of the new "+ tableName);

                int id = 0;
                try{
                    id = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Oops something happened...");
                    continue;
                }
                System.out.println("Please enter the name of the new " + tableName);
                scanner.nextLine(); // Consume previous line
                String name = scanner.nextLine();
                // Establish connection
                Connection connection = connectDatabase();
                // SQL commands
                String SQLCommandChangeQty =
                        "INSERT INTO "+ tableName + " VALUES ( " + id + ", '" + name + "');";

                // Handle null exception
                if (connection != null) {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQLCommandChangeQty);
                    break;
                }
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
                System.out.println("\n----------\n*** " + tableName + " ***\n----------");
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
     * Asks the user for all ids and descriptions then adds -
     * recode to projects table.
     * */
    public static void addProject(){
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);

                String projectName;
                int engineerId;
                int managerId;
                int architectId;
                int customerId;
                String shortDesc;
                String due_date;

                // Get name of project
                System.out.print("What is the name of the new project: ");
                projectName = scanner.nextLine();

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

                // Get due date
                System.out.print("Set the due date 0000-00-00: ");
                due_date = scanner.nextLine();

                // Using project object to add to table
                Project project = new Project(projectName, engineerId, managerId,
                        architectId, customerId,shortDesc,due_date);
                // Establish connection
                Connection connection = connectDatabase();
                // SQL commands
                String SQLCommandChangeQty =
                        "INSERT INTO projects (project_name, engineer_id, manager_id," +
                                "architect_id, customer_id, short_desc, is_finalized," +
                                "start_date, due_date, end_date" +
                                ") VALUES " +
                                "('" + project.getProjectName() +
                                "', " + project.getEngineerId() +
                                ", " + project.getManagerId() +
                                ", " + project.getArchitectId() +
                                ", " + project.getCustomerId() +
                                ", '" + project.getShortDescription() +
                                "', " + project.getFinalised() +
                                ", '" + project.getStart_date() +
                                "', '" + project.getDue_date() +
                                "', '" + project.getCompleted_date() +
                                "');";

                // Handle null exception
                if (connection != null) {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(SQLCommandChangeQty);
                    System.out.println("Adding project...");
                    break;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            catch (Exception e) {
                System.out.println("An error occurred sorry you will have to re-enter everything, Sorry :(");
            }
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
        while (true){
            try{
                //
                Scanner scanner = new Scanner(System.in);
                Connection connection = connectDatabase();
                System.out.println("What do you want to update?\n" +
                        "1. Project Name\n" +
                        "2. Engineer ID\n" +
                        "3. Manager ID\n" +
                        "4. Architect ID\n" +
                        "5. Customer ID\n" +
                        "6. Short Description\n" +
                        "7. Finalise\n" +
                        "8. Due date\n" +
                        "9. Done");

                int userSelection = scanner.nextInt();

                if (Objects.equals(userSelection, 1)){
                    System.out.print("Please enter the new value: ");
                    scanner.nextLine(); // Consume previous line
                    String newValue = scanner.nextLine();
                    String SQL = "Update projects set project_name = '"+ newValue+"' where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }

                else if (Objects.equals(userSelection, 2)){
                    System.out.print("Please enter the new value: ");
                    int newValue = scanner.nextInt();
                    String SQL = "Update projects set engineer_id = "+ newValue+" where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 3)){
                    System.out.print("Please enter the new value: ");
                    int newValue = scanner.nextInt();
                    String SQL = "Update projects set manager_id = "+ newValue+" where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 4)){
                    System.out.print("Please enter the new value: ");
                    int newValue = scanner.nextInt();
                    String SQL = "Update projects set architect_id = "+ newValue+" where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 5)){
                    System.out.print("Please enter the new value: ");
                    int newValue = scanner.nextInt();
                    String SQL = "Update projects set customer_id = "+ newValue+" where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 6)){
                    System.out.print("Please enter the new value: ");
                    scanner.nextLine(); // Consume previous line
                    String newValue = scanner.nextLine();
                    String SQL = "Update projects set short_desc = '"+ newValue +"' where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 7)){
                    String todayDate = String.valueOf(LocalDate.now());
                    System.out.println("Date completed: " + todayDate);
                    String SQL = "Update projects set is_finalized = "+ 1 + "," +
                            " end_date = '"+ todayDate +"' where id = " + id +";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                }
                else if (Objects.equals(userSelection, 8)){
                    System.out.print("Please enter the new date 0000-00-00: ");
                    scanner.nextLine(); // Consume previous line
                    String newValue = scanner.nextLine();
                    String SQL = "Update projects set due_date = '"+ newValue +"' where id = " + id + ";";
                    if (connection != null){
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(SQL);
                    }
                } else if (Objects.equals(userSelection, 9)) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Wrong value!");
            }
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
                projectsTablePrintTemp("All Projects", results);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * Prints all the projects that are not completed
     * */
    public static void findALlUncompletedProjects(){
        try{
            Connection connection = connectDatabase();
            String SQL = "SELECT * FROM projects WHERE is_finalized = 0 ;";
            ResultSet results;

            if (connection != null){
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQL);

                projectsTablePrintTemp("Unfinished projects", results);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * Prints out all the projects that are overdue and not finalized
     * */
    public static void findAllOverDueProjects(){
        try{
            String todayDate = String.valueOf(LocalDate.now());
            Connection connection = connectDatabase();
            String SQL = "SELECT * FROM projects " +
                    "WHERE due_date < '"+ todayDate + "' and is_finalized = 0;";
            ResultSet results;

            if (connection != null){
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQL);

                projectsTablePrintTemp("Over due projects", results);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * Get project with using the name or id
     *  */
    public static void searchProject(int id){
        try{
            Connection connection = connectDatabase();
            String SQL = "SELECT * FROM projects " +
                    "WHERE id = "+ id +";";
            ResultSet results;

            if (connection != null){
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQL);

                projectsTablePrintTemp("Project with the id of " + id, results);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void searchProject(String projectName){
        try{
            Connection connection = connectDatabase();
            String SQL = "SELECT * FROM projects " +
                    "WHERE project_name = '"+ projectName +"';";
            ResultSet results;

            if (connection != null){
                Statement statement = connection.createStatement();
                results = statement.executeQuery(SQL);

                projectsTablePrintTemp("Project with the name of " + projectName, results);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Format for printing out projects table
     * @param title of the printed out table
     * @param results of the SQL query
     * */
    private static void projectsTablePrintTemp(String title, ResultSet results){
        try{
            int count = 1;
            System.out.println("\n----------\n*** "+ title +" ***\n----------");
            while (results.next()){
                String finalised = Objects.equals(results.getInt(8), 0)  ? "Not Finalised" : "Is Finalised";
                System.out.println("\n----------\nProject Number " + count + "\n----------");
                System.out.println("Project ID: " + results.getInt(1));
                System.out.println("Project Name: " + results.getString(2));
                System.out.println("Engineer ID: " + results.getInt(3));
                System.out.println("Manager ID: " + results.getInt(4));
                System.out.println("Architect ID: " + results.getInt(5));
                System.out.println("Customer ID: " + results.getInt(6));
                System.out.println("Short Desc: " + results.getString(7));
                System.out.println("Is finalised: " + (finalised));
                System.out.println("Start Date ID: " + results.getString(9));
                System.out.println("Due Date: " + results.getString(10));
                System.out.println("Completed Date: " + results.getString(11));
                count ++;
            }
            System.out.println("----------\n*** End ***\n----------");
        } catch (SQLException e) {

            System.out.println(e);
        }
    }
}


//TODO: REMOVE
//create table projects (id int auto_increment primary key,project_name varchar(50), engineer_id int, manager_id int, architect_id int, customer_id int, short_desc varchar(500), is_finalized int, start_date varchar(50), due_date varchar(50),  end_date varchar(50));
