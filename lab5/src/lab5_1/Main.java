package lab5_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        for (int i=0; i<23; ++i) {
            accounts.add(new BankAccount());
             }
        for (BankAccount ba: accounts) {
            System.out.println(ba);
        }

        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("KIS", "PISTA"));

        customers.get(0).addAccount(new BankAccount());
        customers.get(0).addAccount(new BankAccount());
        //////////////////////
        customers.add(new Customer("Nagy", "Alma"));

        customers.get(1).addAccount(new BankAccount());
        customers.get(1).addAccount(new BankAccount());
        /////////////////////////////
        customers.add(new Customer("Piros", "Korte"));

        customers.get(2).addAccount(new BankAccount());
        customers.get(2).addAccount(new BankAccount());

        int z=0;
        for (Customer customer : customers) {
            System.out.println(customers.get(z).toString());
            ++z;
        }


         */
        Bank bank1 = new Bank("AsD");
        bank1.addCustomer("Fekete", "Marci");
        bank1.addCustomer("Kovacs", "Doboz");

        bank1.getCustomer(0).addAccount(new BankAccount());
        bank1.getCustomer(0).addAccount(new BankAccount());

        bank1.getCustomer(1).addAccount(new BankAccount());
        bank1.getCustomer(1).addAccount(new BankAccount());

        for (int i=0; i<bank1.numCustomers(); ++i) {
            if (bank1.getCustomer(i).getId() == 1) {
                System.out.println(bank1.getCustomer(i));
            }
        }

        bank1.getCustomer(0)....



    }
}
