package lab5_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 0;
    private final int id;
    private String firstName, lastName;

    private BankAccount account;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    //private BankAccount accounts[] = new BankAccount [MAX_ACCOUNTS];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        numCustomers++;
        id = numCustomers;
    }


    public int getNumAccounts() {
        return accounts.size();
    }
    //itt mit kell írni?
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }


    public String getFirstName(){
        return firstName;
    }
    public String getLastNameName(){
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void closeAccount(BankAccount account) {
        account = null;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n\t" + account.toString();
        // return "Name: " + firstName + lastName + "\n\t" + getAccount().getAccountNumber() + getAccount().getBalance();
    }
}


