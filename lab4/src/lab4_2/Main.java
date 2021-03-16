package lab4_2;

import lab4_1.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //readFilePrintItsLineNumbered("lab4_1_input.csv");

        ArrayList<Customer> accounts = readFilePrintItsLineNumbered("lab4_2_input.txt");
        for (Customer customer : accounts) {
            System.out.println(accounts);
        }


    }


    //for TXT
    public static ArrayList<Customer> readFilePrintItsLineNumbered( String fileName ){
        ArrayList<Customer> customer = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner( new File(fileName));
            for (int i=0; scanner.hasNextLine(); ++i) {
                if (scanner != null) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();

                        if( line.isEmpty() ){
                            continue;
                        }
                        String[] items = line.split(",");
                        // trim: eliminates leading and trailing spaces
                        String first = items[0].trim();
                        String second = items[1].trim();
                        String third = items[2].trim();

                        if (first == "Customer") {
                            customer.add(new Customer(second, third));
                        }
                        if (first == "Account") {
                            BankAccount account = new BankAccount(second, Integer.parseInt(third));

                        }

                    }
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }


}

