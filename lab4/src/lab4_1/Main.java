package lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //readFilePrintItsLineNumbered("lab4_1_input.csv");

        ArrayList<Person> persons = readFromCSVFile("lab4_1_input.csv");
        for (Person person : persons) {
            System.out.println(person);
        }

        readFilePrintItsLineNumbered("lab4_1_input.txt");
    }


    //for TXT
    public static void readFilePrintItsLineNumbered( String fileName ){
        // Open the file
        Scanner scanner = null;
        try {
            scanner = new Scanner( new File(fileName));
            for (int i=1; scanner.hasNextLine(); ++i) {
                String line = scanner.nextLine();
                System.out.println(i + " " + line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//...
    }

    //for CSV
    public static ArrayList<Person> readFromCSVFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();

        // Open the file
        Scanner scanner = null;
        try {
            scanner = new Scanner( new File(fileName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if( line.isEmpty() ){
                    continue;
                }
                String[] items = line.split(",");
                // trim: eliminates leading and trailing spaces
                String firstName = items[0].trim();
                String lastName = items[1].trim();
                int birthYear = Integer.parseInt(items[2].trim());
                //Integer.parseInt(asd)

                //Person person = new Person(firstName, lastName, birthYear);
                //persons.add(person);


                persons.add(new Person(firstName, lastName, birthYear));
            }
        }




        return persons;
    }
}

/*
try {
                //FILE file = new File(fileName);
                scanner = new Scanner( new File(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
 */

/*
while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                }
 */