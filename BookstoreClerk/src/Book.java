public class Book {
    /*
    * Book object
    */
    // Variables
    private final int id;
    private final String title;
    private final String Author;
    private final int Qty;

    // constructors
    public Book(int id, String title, String author, int qty) {
        this.id = id;
        this.title = title;
        Author = author;
        Qty = qty;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getQty() {
        return Qty;
    }
}
