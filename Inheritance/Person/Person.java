package Inheritance.Person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // setters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    // getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        if (age < 0 || age > 100){
            this.age = 0;
        }
        else{
            this.age = age;
        }
    }
    public boolean isTeen(){
        if (age < 20 && age > 12){
            return true;
        }
        return false;
    }
    public String getFullName(){
        if (firstName == null && lastName == null){
            return "";
        }
        else if (firstName != null && lastName == null){
            return firstName;
        }
        else if (firstName == null && lastName != null){
            return lastName;
        }
        else{
            if (firstName.isEmpty()){
                return lastName;
            }
            else if (lastName.isEmpty()){
                return firstName;
            }
            else{
                return firstName + " " + lastName; 
            }
        }
    }

}
