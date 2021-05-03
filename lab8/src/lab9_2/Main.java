package lab9_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import lab9_1.MyDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("92");
        Company company1 = new Company("Asd");
        System.out.println("Company name: " + company1.getName());

        MyDate date1 = new MyDate(1998,05, 05);
        Employee emp1 = new Employee("Kis", "Pista", 500, date1);
        System.out.println(emp1.toString());
        company1.hire(emp1);
        company1.printAll(System.out);


    }
}