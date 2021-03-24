package lab6_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("AD");
        SavingsAccount account = new SavingsAccount(3.5);
        System.out.println(account);

        CheckingAccount account1 = new CheckingAccount(1000);
        System.out.println(account1);

        Customer customer1 = new Customer("Asztalos", "Katalin");
        customer1.addAccount(account);
        customer1.addAccount(account1);

        account.deposit(10);
        account1.deposit(20);
        System.out.println(customer1.toString());
        //System.out.println(customer1.toString());


    }
}
