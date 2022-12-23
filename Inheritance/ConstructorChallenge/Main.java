package Inheritance.ConstructorChallenge;

public class Main {

    public static void main(String[] args) {
        
        Customer customer = new Customer();
        System.out.println(customer.getLimit());
        System.out.println(customer.getEmailAddress());
        System.out.println(customer.getName());
    }
    
}
