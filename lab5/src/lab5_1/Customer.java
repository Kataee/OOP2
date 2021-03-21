package lab5_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 0;
    private final int id;
    private String firstName, lastName;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    //private BankAccount accounts[] = new BankAccount [MAX_ACCOUNTS];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        numCustomers++;
        id = numCustomers;
    }

    public int getId() { return id; }

    public int getNumAccounts() {
        return accounts.size();
    }

    //nem tudom ezt
    /*
    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> accountNumbers = null;
        for (BankAccount account : accounts) {
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
    }
    */


    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    //nem tudom ez mit kellene csinaljon, s hogyan
    //like.. BankAccount type és string input
    /*
    public BankAccount getAccount(String account) {
        if (getNumAccounts() > 0) {

            return accounts.get(0);
        }
        return null;
    }

     */


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
        return "Name: " + firstName + " " + lastName + ", client: " + id+ "\n\t" + accounts.toString();
        // return "Name: " + firstName + lastName + "\n\t" + getAccount().getAccountNumber() + getAccount().getBalance();
    }
}


