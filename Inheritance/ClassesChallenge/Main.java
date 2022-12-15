package Inheritance.ClassesChallenge;

public class Main {
    public static void main(String[] args) {
        Bank account1 = new Bank();


        account1.setAccountBalance(1000);
        account1.setAccountEmail("Happy@golucky.com");
        account1.setAccountName("Happy");
        account1.setAccountNumber(123456);
        account1.setPhoneNumber("0607904381");

        account1.deposit(1000);
        account1.withdraw(200);

        account1.printAccountInfo();


    }
}
