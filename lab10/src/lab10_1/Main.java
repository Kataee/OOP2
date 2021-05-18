package lab10_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       //1. feladat
        //readFromStandardInput();


        //2. feladat
        readFromFile("students.csv");
    }

    //...throws NumberFormatException
    public static void readFromStandardInput() {
        Scanner console = new Scanner(System.in);
        System.out.println("Input: ");
        String line = console.nextLine();
        double sum = 0;
        String[] items = line.split(" ");
        for (String item : items) {
            try {
                sum += Double.parseDouble(item.trim());
            }
            catch (NumberFormatException ex) {
                //System.out.println("Invalid item: " + item);
                System.out.println(ex.getMessage());
            }

        }

        System.out.println("Sum of numbers: " + sum);
    }

    public static void readFromFile(String filename) {
        Scanner scanner = null;
        PrintStream output = null;
        try {
            //open file
            scanner = new Scanner(new File(filename));
            output = new PrintStream("warning.csv");

            //read from file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.println("Input line: " + line);
                String[] items = line.split(",");

                //NeptunId, firstName, lastName, credits, birthYear, birthMonth, birthDay
                try {
                    String neptunId = items[0];
                    String firstName = items[1];
                    String lastName = items[2];
                    //try {
                        int credits = Integer.parseInt(items[3].trim());
                    //} catch (NumberFormatException e) {
                    //    System.out.println("Number format exception for credits");
                    //}


                    LocalDate birthdate = LocalDate.of(Integer.parseInt(items[4].trim()),
                            Integer.parseInt(items[5].trim()),
                            Integer.parseInt(items[6].trim()));
                } catch (ArrayIndexOutOfBoundsException e) {
                    //nem lehet külömböző catch-ben ugyan az a feladat
                    //mondjuk 2 catch -ban e.printStackTrace()...
                    System.out.println("Index out of bounds");
                    output.println("Error message: INCOMPLETE LINE: " + line);
                } catch (NumberFormatException e) {
                    System.out.println("Number format exception");
                    output.println("Error message: NUMBER FORMAT EXCEPTION: " + line);
                } catch (DateTimeException e) {
                    System.out.println("DateTimeException");
                    output.println("Error message: INVALID DATE: " + line);
                }

            }
            //a catch ágakat egybe is lehet tenni, ha mondjuk ugyan azt a hibauzenetet akarjuk kiiratni
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
         finally {
            //ide olyan dolgokat írjunk, amiket mindenként
            //szeretnénk végrehajtatni
            //close the file
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
