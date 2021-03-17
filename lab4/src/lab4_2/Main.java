package lab4_2;

import lab4_1.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Customer> customers = readFilePrintItsLineNumbered("lab4_2_input.txt");
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName());
            System.out.println(customer.getLastNameName());
        }


    }


    //for TXT
    public static ArrayList<Customer> readFilePrintItsLineNumbered( String fileName ){
        ArrayList<Customer> customer = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner( new File(fileName));
            if (scanner != null) {
                for (int i=0; scanner.hasNextLine(); ++i) {
                    {
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

                            if (first.equals("Customer")) {
                                customer.add(new Customer(second, third));
                            }
                            if (first.equals("Account")) {
                                BankAccount account = new BankAccount(second, Integer.parseInt(third));
                                customer.get(customer.size()-1).addAccount(account);
                            }

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

