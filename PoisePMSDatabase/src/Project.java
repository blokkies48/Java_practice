import java.time.LocalDate;

/**
 * This is the structure for adding an entry to the projects table
 * @author Jonathan
 * */
public class Project {

    private final String projectName;
    private final int engineerId;
    private final int managerId;
    private final int architectId;
    private final int customerId;
    private final String shortDescription;
    private final byte finalised;
    private final String start_date ;
    private final String due_date;
    private final String completed_date;


    /**
     * Constructor
     * ID is handled with auto_increment
     * @param projectName name of the project
     * @param engineerId The engineer's ID
     * @param managerId The manager's ID
     * @param architectId The architect's ID
     * @param customerId The customer's ID
     * @param shortDescription A short description of the project
     * @param due_date of the project
     */

    public Project(
             String projectName, int engineerId,
            int managerId, int architectId, int customerId,
            String shortDescription, String due_date) {

        this.projectName = projectName;
        this.engineerId = engineerId;
        this.managerId = managerId;
        this.architectId = architectId;
        this.customerId = customerId;
        this.shortDescription = shortDescription;
        this.finalised = 0;
        this.start_date = String.valueOf(LocalDate.now());
        this.due_date = due_date;
        this.completed_date = "0000-00-00";
    }

    // Getter methods
    public String getProjectName() {
        return projectName;
    }

    public int getEngineerId() {
        return engineerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getArchitectId() {
        return architectId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public byte getFinalised() {
        return finalised;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getCompleted_date() {
        return completed_date;
    }
}
