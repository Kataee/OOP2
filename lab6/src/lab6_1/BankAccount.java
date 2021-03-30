package lab6_1;

public class BankAccount {

    public static final String PREFIX = "OTP";
    public static int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;

    private final String accountNumber;
    protected double balance;


    protected BankAccount() {
        this.accountNumber = createAccountNumber();
        //this.balance = 0;
        numAccounts++;
    }

    private String createAccountNumber() {
        int zerosLength = ACCOUNT_NUMBER_LENGTH - PREFIX.length();

        //for safety
        if (zerosLength < 1) {
            zerosLength = 1;
        }
        String formatted = String.format("%0" + zerosLength +"d", numAccounts);
        return PREFIX + formatted;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
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
        return "Account number: " + this.accountNumber + " balance: " + this.balance + "\n\t";
    }

}