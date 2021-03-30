package lab6_1;

public class CheckingAccount extends BankAccount{
    private double overdraftLimit;

    public CheckingAccount(double overdraftLimit) {
        super();
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /*
    @Override
    public boolean withdraw(double value) {
        return super.withdraw(value);
    }
     */
    @Override
    public boolean withdraw(double value) {
        if (this.balance + overdraftLimit >= value) {
            this.balance -= value;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "checking account, overdraft limit: " + overdraftLimit;
    }
}
