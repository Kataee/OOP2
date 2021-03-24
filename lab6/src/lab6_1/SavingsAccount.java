package lab6_1;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate (double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {
        this.balance += interestRate*balance;
    }

    @Override
    public String toString() {
        return super.toString() + "savings acount, interest rate: " + interestRate;
    }
}
