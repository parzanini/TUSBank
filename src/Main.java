import Account.* ;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> tusAccounts = new ArrayList<>();
        LocalDate newDate = LocalDate.now();

        //TEST USER
        Customer test = new Customer("Test", "Test", "Test", 1);
        DepositAccount testAccount = new DepositAccount(test,100,newDate);
        tusAccounts.add(testAccount);

        boolean isTrue = true;
        System.out.println("Welcome to Tus Bank\n");


        do {
            System.out.println("Type the option desired \n1 - Deposit Money \n2 - Withdraw Money \n3 - Check Balance \n0 - Exit");
            int option = input.nextInt();
            if(option == 0) {
                isTrue = false;
            } else if (option == 1){
                depositMoney(tusAccounts);
                System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                option = input.nextInt();
                if (option == 2){
                    isTrue = false;
                }
            }
        }while (isTrue);

    }

    private static void depositMoney(ArrayList<Account> tusAccounts) {
        double balance = 0;
        System.out.println("Please type your customer ID");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        for (Account a: tusAccounts){
            if(option == a.getCustID().getCustID()){
                System.out.println("How much do you want to Deposit?");
                double deposit = input.nextDouble();
                balance = a.getBalance();
                a.setBalance(balance+deposit);
                System.out.println("Your new balance is: " + a.getBalance());
            }
        }

    }
}