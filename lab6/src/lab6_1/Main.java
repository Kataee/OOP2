package lab6_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("OTP");

        //create two new customers
        Customer customer1 = new Customer("Asztalos", "Katalin");
        Customer customer2 = new Customer("Nagy", "Ferenc");

        //add the two customer to the bank
        bank1.addCustomer(customer1.getFirstName(), customer1.getLastNameName());
        bank1.addCustomer(customer2.getFirstName(), customer2.getLastNameName());


        //add two accounts to each customer, one saving & one checking
        SavingsAccount savingsAccountCustomer1Account1 = new SavingsAccount(5);
        CheckingAccount checkingAccountCustomer1Account1 = new CheckingAccount(5);


        customer1.addAccount(savingsAccountCustomer1Account1);
        customer1.addAccount(checkingAccountCustomer1Account1);


        SavingsAccount savingsAccountCustomer2Account1 = new SavingsAccount(5);
        CheckingAccount checkingAccountCustomer2Account1 = new CheckingAccount(5);

        customer2.addAccount(savingsAccountCustomer2Account1);
        customer2.addAccount(checkingAccountCustomer2Account1);


        //deposit some money to each account
        savingsAccountCustomer1Account1.deposit(100);
        checkingAccountCustomer1Account1.deposit(200);

        savingsAccountCustomer2Account1.deposit(300);
        checkingAccountCustomer2Account1.deposit(400);

        //printing the customers to the std output
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());

        //in case of savingsAccount call the addInterest method /this may be the setInterest
        //since we don't have addInterest method
        savingsAccountCustomer1Account1.setInterestRate(10);

        //printing the customers to the std output
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());


        //withdraw
        savingsAccountCustomer1Account1.withdraw(50);
        checkingAccountCustomer1Account1.withdraw(60);

        savingsAccountCustomer2Account1.withdraw(70);
        checkingAccountCustomer2Account1.withdraw(80);


        //printing the customers to the std output
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());



    }
}
