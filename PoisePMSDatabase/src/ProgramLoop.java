import java.util.Objects;
import java.util.Scanner;
/**
 * The program loop
 * */
public class ProgramLoop {
    /**
     * Takes user input and call the appropriate function
     * All functionality in this method
     * */
    public static void mainLoop(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "Please enter a number of the operation you want to do: \n" +
                            "1. Show table info\n" +
                            "2. Add to table\n" +
                            "3. Delete from table\n" +
                            "4. Update info of a project\n" +
                            "5. Search for a project\n" +
                            "6. Exit program"
            );
            int userChoice = 0;
            try{
                userChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Oops something happened...");
                continue;
            }
            if (Objects.equals(userChoice, 1)){
                while (true){
                    scanner = new Scanner(System.in);
                    System.out.println("Please select one of the following\n" +
                            "1. Show all projects\n" +
                            "2. Show all engineers\n" +
                            "3. Show all managers\n" +
                            "4. Show all architects\n" +
                            "5. Show all customers\n" +
                            "6. Show all unfinished projects\n" +
                            "7. Show all overdue projects\n" +
                            "8. Back");
                    int userChoice1 = 0;
                    try{
                        userChoice1 = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Oops something happened...");
                        continue;
                    }

                    if (Objects.equals(userChoice1, 1)){
                        ConnectToDatabase.printAllProjects();
                    }
                    else if (Objects.equals(userChoice1, 2)){
                        ConnectToDatabase.printAllTable("engineer");
                    }
                    else if (Objects.equals(userChoice1, 3)){
                        ConnectToDatabase.printAllTable("project_manager");
                    }
                    else if (Objects.equals(userChoice1, 4)){
                        ConnectToDatabase.printAllTable("architect");

                    }
                    else if (Objects.equals(userChoice1, 5)){
                        ConnectToDatabase.printAllTable("customer");

                    }
                    else if (Objects.equals(userChoice1, 6)){
                        ConnectToDatabase.findALlUncompletedProjects();
                    }
                    else if (Objects.equals(userChoice1, 7)){
                        ConnectToDatabase.findAllOverDueProjects();
                    }
                    else if (Objects.equals(userChoice1, 8)){
                        System.out.println("Going back...");
                        break;
                    }
                }
            }
            else if (Objects.equals(userChoice, 2)){
                while (true){
                    scanner = new Scanner(System.in);
                    System.out.println("Please select one of the following\n" +
                            "1. Add to projects\n" +
                            "2. Add to engineer\n" +
                            "3. Add to project_manager\n" +
                            "4. Add to architect\n" +
                            "5. Add to customer\n" +
                            "6. Back");
                    int userChoice1 = 0;
                    try{
                        userChoice1 = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Oops something happened...");
                        continue;
                    }
                    if (Objects.equals(userChoice1, 1)){
                        ConnectToDatabase.addProject();
                    }
                    else if (Objects.equals(userChoice1, 2)){
                        ConnectToDatabase.addToTable("engineer");
                    }
                    else if (Objects.equals(userChoice1, 3)){
                        ConnectToDatabase.addToTable("project_manager");
                    }
                    else if (Objects.equals(userChoice1, 4)){
                        ConnectToDatabase.addToTable("architect");

                    }
                    else if (Objects.equals(userChoice1, 5)){
                        ConnectToDatabase.addToTable("customer");

                    }
                    else if (Objects.equals(userChoice1, 6)){
                        System.out.println("Going back...");
                        break;
                    }
                }
            }
            else if (Objects.equals(userChoice, 3)){
                while (true){
                    scanner = new Scanner(System.in);
                    System.out.println("Please select one of the following\n" +
                            "1. Delete from projects\n" +
                            "2. Delete from engineer\n" +
                            "3. Delete from project_manager\n" +
                            "4. Delete from architect\n" +
                            "5. Delete from customer\n" +
                            "6. Back");
                    int userChoice1 = 0;
                    try{
                        userChoice1 = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Oops something happened...");
                        continue;
                    }
                    if (userChoice1 <= 5){
                        System.out.println("Select the id of the record you want to delete: ");
                        int idSelected = scanner.nextInt();
                        if (Objects.equals(userChoice1, 1)){
                            ConnectToDatabase.deleteFromTable("projects", idSelected);
                        }
                        else if (Objects.equals(userChoice1, 2)){
                            ConnectToDatabase.deleteFromTable("engineer",idSelected);
                        }
                        else if (Objects.equals(userChoice1, 3)){
                            ConnectToDatabase.deleteFromTable("project_manager",idSelected);
                        }
                        else if (Objects.equals(userChoice1, 4)){
                            ConnectToDatabase.deleteFromTable("architect",idSelected);

                        }
                        else if (Objects.equals(userChoice1, 5)){
                            ConnectToDatabase.deleteFromTable("customer",idSelected);
                        }
                    }
                    else if (userChoice1 == 6){
                        System.out.println("Going back...");
                        break;
                    }
                }
            }
            else if (Objects.equals(userChoice, 4)){
                while (true){
                    scanner = new Scanner(System.in);
                    System.out.println("Enter the id of the project you want to update");
                    int id = 0;
                    try{
                        id = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Oops something happened...");
                        continue;
                    }
                    ConnectToDatabase.updateProjectInfo(id);
                    System.out.println("Going back...");
                    break;
                }
            }
            else if (Objects.equals(userChoice, 5)){
                while (true){

                    scanner = new Scanner(System.in);
                    System.out.println("Please select one of the following\n" +
                            "1. Search using ID\n" +
                            "2. Search using Name\n" +
                            "3. Back");
                    int choice = 0;
                    try{
                        choice = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Oops something happened...");
                        continue;
                    }
                    if (Objects.equals(choice, 1)){
                        while (true){
                            System.out.println("Enter the id of the project you want.");
                            scanner = new Scanner(System.in);
                            int id = 0;
                            try{
                                id = scanner.nextInt();
                            } catch (Exception e) {
                                System.out.println("Oops something happened...");
                                continue;
                            }
                            ConnectToDatabase.searchProject(id);
                            System.out.println("Going back...");
                            break;
                        }
                    }
                    else if (Objects.equals(choice, 2)){
                        System.out.println("Enter the name of the project you want.");
                        scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        ConnectToDatabase.searchProject(name);
                    }
                    else if (Objects.equals(choice, 3)){
                        System.out.println("Going back...");
                        break;
                    }
                }
            }
            else if (Objects.equals(userChoice, 6)) {
                System.out.println("Exciting...");
                break;
            }
        }
    }
}
