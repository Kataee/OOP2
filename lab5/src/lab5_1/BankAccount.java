package lab5_1;


public class BankAccount {

    public static final String PREFIX = "OTP";
    public static int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;

    private final String accountNumber;
    private double balance;


    public BankAccount() {
        this.accountNumber = createAccountNumber();
    }

    private String createAccountNumber() {

        return PREFIX;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        if(value > 0) {
            this.balance += value;
        }
    }

    public boolean withdraw(double value) {
        if(value > 0 && value <= this.balance) {
            this.balance -= value;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.accountNumber + " balance: " + this.balance;
    }

}