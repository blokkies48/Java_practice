
public class Main {
    public static void main(String[] args) {
        ConnectDatabase.connectDatabase();
        System.out.println("got here");
        ConnectDatabase.addInitialBooks();
        // TODO: REMOVE
        // Test
        //ConnectDatabase.enterBook(new Book(3007, "hello", "hello", 32));
        // TODO: END REMOVE

    }
}
// TODO REMOVE
/*
* create table books(id int primary key,
					Title varchar(50),
                    Author varchar(50),
                    Qty int);
*
* */
// TODO: END REMOVE

