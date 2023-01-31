public class SubTableStructure {
    private final int id;
    private final String name;

    /**
     * Constructor
     * @param id of the current item
     * @param name of the current item
     * */
    public SubTableStructure(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return id of current item
     * */
    public int getId() {
        return id;
    }

    /**
     * @return name of current item
     * */
    public String getName() {
        return name;
    }
}