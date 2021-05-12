package lab12_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {
    private String fileName;

    public ArrayList<Product> products = new ArrayList<Product>();
    private HashMap<Integer, Product> productsH = new HashMap<Integer, Product>();

    public void read(String fileName) {
        try (Scanner scanner = new Scanner( new File(fileName))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println(line);
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                // trim: eliminates leading and trailing spaces
                //splitting the line into firstName, lastName, salary, birthDate and department if we have that
                int ID = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                int amount = Integer.parseInt(items[2].trim());
                int price = Integer.parseInt(items[3].trim());

                Product newProduct = new Product(ID, name, amount, price);
                products.add(newProduct);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(String fileName) {
        int updatedProductCount = 0;
        try (Scanner scanner = new Scanner( new File(fileName))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println(line);
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                // trim: eliminates leading and trailing spaces
                //splitting the line into firstName, lastName, salary, birthDate and department if we have that
                int ID = Integer.parseInt(items[0].trim());
                int amount = Integer.parseInt(items[1].trim());



                for (Product i : products) {
                    if (i.getID() == ID) {
                        i.updateAmount(amount);
                        updatedProductCount++;
                        //printing the updated product information
                        //System.out.println("Updated: " + i.toString());
                    }
                }
            }
            System.out.println(updatedProductCount + " products updated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printProducts() {
        for (Product i : products) {
            System.out.println(i.toString());
        }
    }


    //##############################################################
    public void readHash(String fileName) {
        File file = new File(fileName);
/*

`       //???  try-with-resource
        //ez a mintakód, de mivel az inputStream byteokat olvas
        //bajos lett volna feldolgozni, de gondolom nem ez számót
        //hogy inputStream -el olvassunk be, hanem a try és a dupla catch?
        //though a második catch -et kiszínezni a program mint unreachable
        try (FileInputStream inputStream = new FileInputStream(file);) {

            //use inputstream to read a file
            int ID;
            int line = inputStream.read();
            while ( line != -1) {
                System.out.println(line);
                line = inputStream.read();
            }
            System.out.println("\n\ntoString");
            System.out.println(inputStream.toString());
            inputStream.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 */

        try (Scanner scanner = new Scanner(new File(fileName))) {
            //
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");

                int ID = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                int amount = Integer.parseInt(items[2].trim());
                int price = Integer.parseInt(items[3].trim());

                Product newProduct = new Product(ID, name, amount, price);
                productsH.put(ID, newProduct);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateH(String fileName) {
        int updatedProductCount = 0;
        try (Scanner scanner = new Scanner( new File(fileName))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println(line);
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                // trim: eliminates leading and trailing spaces
                //splitting the line into firstName, lastName, salary, birthDate and department if we have that
                int ID = Integer.parseInt(items[0].trim());
                int amount = Integer.parseInt(items[1].trim());

                if (productsH.get(ID) == null) {
                    System.out.println("Inexistent ID: " + ID);
                    continue;
                }
                productsH.get(ID).updateAmount(amount);
                System.out.println("asd " + productsH.get(ID));
                updatedProductCount++;
            }
            System.out.println(updatedProductCount + " products updated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printProductsH() {
        for (Integer i : productsH.keySet()) {
            System.out.println("Key: " + i + ", " + productsH.get(i).toString());
        }
    }
}
