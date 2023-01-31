/**
 * This is the structure for adding an entry to the projects table
 * @author Jonathan
 * */
public class Project {
    int id;
    int engineerId;
    int managerId;
    int architectId;
    int customerId;
    String shortDescription;


    /**
     * Constructor
     * @param id The project's ID
     * @param engineerId The engineer's ID
     * @param managerId The manager's ID
     * @param architectId The architect's ID
     * @param customerId The customer's ID
     * @param shortDescription A short description of the project
     */

    public Project(int id, int engineerId, int managerId, int architectId, int customerId, String shortDescription) {
        this.id = id;
        this.engineerId = engineerId;
        this.managerId = managerId;
        this.architectId = architectId;
        this.customerId = customerId;
        this.shortDescription = shortDescription;
    }

    /**
     * @return id of current project
     * */
    public int getId() {
        return id;
    }

    /**
     * @return id of the engineer
     * */
    public int getEngineerId() {
        return engineerId;
    }

    /**
     * @return id of the project manager
     * */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @return id of the architect
     * */
    public int getArchitectId() {
        return architectId;
    }

    /**
     * @return id of the customer
     * */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @return the short description
     * */
    public String getShortDescription() {
        return shortDescription;
    }
}
