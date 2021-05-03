package lab9_2;

import lab9_1.MyDate;

public class Employee {
    private final int ID;
    private String firstName;
    private String lastName;
    private double salary;
    private MyDate birthDate;
    private static int counter;


    public Employee(String firstName, String lastName, double salary, MyDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        ID = counter++;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        //System.out.println("Customer ID: " + ID + ", name: " + firstName + " " + lastName + ", salary: " + salary + ", birth: " + birthDate +"\n");
        return "Customer ID: " + ID + ", name: " + firstName + " " + lastName + ", salary: " + salary + ", birth: " + birthDate +"\n";
    }
}







