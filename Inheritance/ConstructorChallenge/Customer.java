package Inheritance.ConstructorChallenge;

public class Customer {
    private String name;
    private int limit;
    private String emailAddress;

    public Customer(String name, int limit, String emailAddress){
        this.name = name;
        this.limit = limit;
        this.emailAddress = emailAddress;
    }

    public Customer(){
        this("Jonathan", "jonathan@cooldude.come");
    }

    public Customer(String name, String emailAddress){
        this(name, 1000, emailAddress);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }
}
