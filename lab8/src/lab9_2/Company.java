package lab9_2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void  setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    /*
    public void hireAll(String) {

    }

     */

    public void fire(int ID) {
        int temp =0 ;
        for (Employee i : employees) {
            if (i.getID() == ID) {
                System.out.println("Firing: " + i.toString());
                employees.remove(temp);
                break;
            }
            temp++;
        }
    }

    public void printAll(PrintStream ps) {
        ps.println("ID, Firstname, Last name; Salary, Birth date ");
        if (employees.size() == 0) {
            System.out.println("Nincsenek alkalmazottak");
            return;
        }
        for (Employee i : employees) {
            ps.println(i.getID() + ", " + i.getFirstName() + ", " + i.getLastName() +", " + i.getSalary() + ", " + i.getBirthDate());
        }
    }
    /*
    //how to do this one
    public void printManagers(PrintStream ps) {
        ps.println("ID, Firstname, Last name; Salary, Birth date, department ");

    }
     */

    void sortByComparator(Comparator<Employee> employeeComparator) {
        Collections.sort(employees, employeeComparator);
    }
}
