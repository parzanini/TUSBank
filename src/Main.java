import Account.*;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> tusAccounts = new ArrayList<>();
        ArrayList<Customer> tusCustomer = new ArrayList<>();
        LocalDate newDate = LocalDate.now();

        //TEST USER
        Address testAddress = new Address("New Street", "Shannon", "Clare", "V14ABCD");
        Customer test = new Customer("Thiago", "Parzanini", "0834456782", testAddress, 1);
        DepositAccount testAccount = new DepositAccount(test, 200, newDate);
        tusAccounts.add(testAccount);

        boolean isTrue = true;
        System.out.println("Welcome to Tus Bank\n");


        do {
            System.out.println("Type the option desired \n1 - Deposit Money \n2 - Withdraw Money \n3 - Check Balance \n0 - Exit");
            int option = input.nextInt();
            if (option == 0) {
                isTrue = false;
            } else if (option == 1) {
                depositMoney(tusAccounts);
                System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                option = input.nextInt();
                if (option == 2) {
                    isTrue = false;
                }
            } else if (option == 2) {
                withdrawMoney(tusAccounts);
                System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                option = input.nextInt();
                if (option == 2) {
                    isTrue = false;
                }
            } else if (option == 3) {
                checkBalance(tusAccounts);
                System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                option = input.nextInt();
                if (option == 2) {
                    isTrue = false;
                }
            } else if (option == 99) {
                System.out.println("ADMIN MODE");
                System.out.println("Type the option desired \n1 - Create New Customer \n2 - Create New Account \n3 - Change AIR(Annual Interest Rate) \n4 - Change overdraft \n5 - List all customers \n6 - List all accounts \n0 - Exit");
                option = input.nextInt();
                if (option == 0) {
                    isTrue = false;
                } else if (option == 1) {
                    System.out.println("Please enter the customer's first name");
                    String firstName = input.next();
                    System.out.println("Please enter the customer's last name");
                    String lastName = input.next();
                    System.out.println("Please enter the customer's phone number");
                    String phone = input.next();
                    System.out.println("Please enter the customer's street");
                    String street = input.next();
                    System.out.println("Please enter the customer's city");
                    String city = input.next();
                    System.out.println("Please enter the customer's county");
                    String county = input.next();
                    System.out.println("Please enter the customer's Eircode");
                    String eircode = input.next();
                    System.out.println("Please enter the customer's ID"); //Create a method to check if the ID already exists
                    int custID = input.nextInt();
                    Address address = new Address(street, city, county, eircode);
                    Customer customer = new Customer(firstName, lastName, phone, address, custID);
                    tusCustomer.add(customer);
                    System.out.println(customer.toString());
                    System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                    option = input.nextInt();
                    if (option == 2) {
                        isTrue = false;
                    }
                } else if (option == 2) {
                    System.out.println("1 - Create a new Deposit Account \n2 - Create a new Current Account");
                    option = input.nextInt();
                    if (option == 1) {
                        System.out.println("Please enter the customer's ID");
                        int custID = input.nextInt();
                        System.out.println("Please enter the customer's balance");
                        double balance = input.nextDouble();
                       Customer customerCreated = getCustomerByID(custID); //Create method to get customer by ID

                        DepositAccount depositAccount = new DepositAccount(customer, balance, dataCreated);
                        System.out.println(depositAccount.toString());
                        System.out.println("Do you want to do a new transaction?(1-yes / 2-no)");
                        option = input.nextInt();
                        if (option == 2) {
                            isTrue = false;
                        }
                    } else if (option == 2) {


                }

            }
            else {
                System.out.println("Invalid option, please enter a valid option.");

            }
        } while (isTrue);

    }

    private static void checkBalance(ArrayList<Account> tusAccounts) {
        System.out.println("Please enter your Account ID to proceed.");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        for (Account a : tusAccounts) {
            if (option == a.getId()) {
                System.out.println("Welcome to Tus Bank," + a.getCustID().getFirstName() + " " + a.getCustID().getLastName());
                System.out.println("Your current balance is: " + a.getBalance());

            }
        }
    }

    private static void withdrawMoney(ArrayList<Account> tusAccounts) {
        System.out.println("Please enter your Account ID to proceed.");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        for (Account a : tusAccounts) {
            if (option == a.getId()) {
                System.out.println("Welcome to Tus Bank," + a.getCustID().getFirstName() + " " + a.getCustID().getLastName());
                System.out.println("How much do you want to Withdraw?");
                double withdraw = input.nextDouble();

                a.setBalance(a.getBalance() - withdraw);
                System.out.println("Your new balance is: " + a.getBalance());
            }
        }
    }

    private static void depositMoney(ArrayList<Account> tusAccounts) {
        double deposit=0;
        System.out.println("Please enter your Account ID to proceed.");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        for (Account a : tusAccounts) {
            if (option == a.getId()) {
                System.out.println("Welcome to Tus Bank," + a.getCustID().getFirstName() + " " + a.getCustID().getLastName());
                System.out.println("How much do you want to Deposit?");
                deposit = input.nextDouble();
                a.setBalance(a.getBalance() + deposit);
                System.out.println("Your new balance is: " + a.getBalance());
            }
        }

    }
}