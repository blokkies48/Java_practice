package Inheritance.ClassesChallenge;

public class Bank {
    private int accountNumber;
    private double accountBalance;
    private String accountName;
    private String accountEmail;
    private String phoneNumber;


    void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
    void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public String getAccountEmail() {
        return accountEmail;
    }
    public String getAccountName() {
        return accountName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void deposit(double amount){
        this.accountBalance += amount;
    }
    public void withdraw(double amount){
        if (amount > this.accountBalance){
            System.out.println("Cannot withdraw amount");
        }
        else{
            this.accountBalance -= amount;
        }
    }

    public void printAccountInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("Account Email: " + accountEmail);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
