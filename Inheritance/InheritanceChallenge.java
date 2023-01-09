package Inheritance;

public class InheritanceChallenge {
    public static void main(String[] args) {
        Employee tim = new Employee("tim", "08/11/1995", "01/01/2023");
        System.out.println(tim);
        System.out.println("Age: " + tim.getAge());
        System.out.println("Pay: " + tim.collectPay());

        SalariedEmployee joe = new SalariedEmployee("joe", "01/01/2000", "01/01/2020", 30000);
        System.out.println(joe);
        joe.isRetired = true;
        System.out.println(joe.collectPay());
    }
}

class Worker{
    private String name;
    private String birthDate;
    protected String endDate;
    public Worker(){
    
    }
    public Worker(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        int currentYear = 2023;
        int birthYear = Integer.parseInt(birthDate.substring(6));

        return currentYear - birthYear;
    }

    public double collectPay(){
        return 0.0;
    }
    public void terminate(String endDate){
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", BirthDate:" + this.birthDate;
    }
}

class Employee extends Worker{

    long employeeId; 
    String hireDate;

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String hireDate){
        super(name, birthDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + this.employeeId;
    }
}

class SalariedEmployee extends Employee{
    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }
    
    @Override
    public double collectPay() {
        int pay = (int) this.annualSalary/26;
        return (isRetired) ? this.annualSalary * 0.9 : pay;
    }
}

class HourlyEmployee extends Employee{

    double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String hireDate, double hourlyPayRate){
        super(name, birthDate,  hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        return this.hourlyPayRate * 40;
    }

    public double getDoublePay() {
        return hourlyPayRate * 2;
    }
}
