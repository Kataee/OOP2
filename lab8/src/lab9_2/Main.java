package lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lab9_1.MyDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("92");
        Company company1 = new Company("Asd");
        System.out.println("Company name: " + company1.getName());

        MyDate date1 = new MyDate(1998,05, 05);
        Employee emp1 = new Employee("Kis", "Pista", 500, date1);
        Employee emp2 = new Employee("Kis", "Antal", 300, date1);
        System.out.println(emp1.toString());
        company1.hire(emp1);
        company1.hire(emp2);

        Manager manager1 = new Manager("Kis", "Margit", 200, date1, "lksf");
        company1.hire(manager1);
        company1.printAll(System.out);

        //print every file in the directory
        /*
        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);
         */

        //read the file
        readFilePrintItsLineNumbered("file.txt");

        company1.hireAll("file.txt");
        company1.printAll(System.out);




    }

    public static void readFilePrintItsLineNumbered( String fileName ){
        try (Scanner scanner = new Scanner( new File(fileName))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}