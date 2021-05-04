package lab9_2;

import lab9_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

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


    public  void hireAll(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner( new File(fileName));
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.isEmpty()) {
                        continue;
                    }
                    //string for the entire read line
                    String[] items = line.split(",");
                    // trim: eliminates leading and trailing spaces
                    //splitting the line into firstName, lastName, salary, birthDate and department if we have that
                    String firstName = items[0].trim();
                    String lastName = items[1].trim();
                    double salary = Integer.parseInt(items[2].trim());

                    int year = Integer.parseInt(items[3].trim());
                    int month = Integer.parseInt(items[4].trim());
                    int day = Integer.parseInt(items[5].trim());
                    MyDate birthDate = new MyDate(year, month, day);


                    if (items.length < 6) {
                        String department = items[6].trim();
                        //creating a new manager
                        Manager manager = new Manager(firstName, lastName, salary, birthDate, department);
                        employees.add(manager);
                        //continue to not add this item twice (notice the word *item* for manager)
                        continue;
                    }

                    //if we don't have a manager by checking if the
                    //string is long enough, we create a basic employee
                    Employee employee = new Employee(firstName, lastName, salary, birthDate);
                    employees.add(employee);



                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


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



