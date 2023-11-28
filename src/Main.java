import Account.*;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Array lists, variables
        Scanner input = new Scanner(System.in);
        ArrayList<Account> tusAccounts = new ArrayList<>();
        ArrayList<Customer> tusCustomer = new ArrayList<>();
        ArrayList<BankStaff> tusBankStaff = new ArrayList<>();
        int menuOption,outterMenuOption;

    // ------------------------------------------- Dummy Data --------------------------------------------------
        populateAccounts(tusAccounts, tusCustomer);
        populateStaff(tusBankStaff);

// ------------------------------------------- Main Menu --------------------------------------------------
        System.out.println("Welcome to Tus Bank\n");

        do {
            System.out.println("Select \n1 - Customer \n2 - Bank Officer \n3 - Bank Manager \n0 - Exit");
            outterMenuOption = input.nextInt();
            if (outterMenuOption == 1){

                do {
                    System.out.println("Type the option desired \n1 - Deposit Money \n2 - Withdraw Money \n3 - Check Balance \n0 - Back to Main Menu");
                    menuOption = input.nextInt();
                    if (menuOption == 1) {
                        depositMoney(tusAccounts);

                    } else if (menuOption == 2) {
                                withdrawMoney(tusAccounts);
                            } else if (menuOption == 3) {
                                checkBalance(tusAccounts);
                            } else if (menuOption == 0){
                                System.out.println("Back to Main Menu\n");
                            } else {
                                System.out.println("Invalid option, please enter a valid option.");
                            }

                        } while (menuOption != 0);
            } else if (outterMenuOption == 2) {
                do {
                    System.out.println("Type the option desired \n1 - Create New Customer \n2 - Create New Account \n3 - Change AIR(Annual Interest Rate) \n4 - Change overdraft \n5 - List all customers \n6 - List all accounts \n0 - Back to Main Menu");
                    menuOption = input.nextInt();
                    if (menuOption == 1) {
                        addNewCustomer(tusCustomer);
                    } else if (menuOption == 2) {
                        createNewAccount(tusAccounts, tusCustomer);
                    } else if (menuOption == 3) {
//                        changeAIR(tusAccounts);
                    } else if (menuOption == 4) {
//                        changeOverdraft(tusAccounts);
                    } else if (menuOption == 5) {
                        for (Customer c : tusCustomer) {
                            System.out.println(c.toString());
                    }} else if (menuOption == 6) {
                        for (Account a : tusAccounts) {
                            System.out.println(a.toString());
                        }
                    } else if (menuOption == 0) {
                        System.out.println("Back to Main Menu");
                    } else {
                        System.out.println("Invalid option, please enter a valid option.");
                    }
                } while (menuOption != 0);
            } else if (outterMenuOption == 3) {
                do {
                    System.out.println("1 - Create New Bank Officer \n0 - Back to Main Menu");
                    menuOption = input.nextInt();
                    if (menuOption == 1) {
                        // Implement code for creating a new bank officer
                    } else if (menuOption == 0) {
                        System.out.println("Back to Main Menu");
                    } else {
                        System.out.println("Invalid option, please enter a valid option.");
                    }
                } while (menuOption != 0);
                }
            } while (outterMenuOption != 0);
    }




    // ------------------------------------------- Dummy Creator Methods --------------------------------------------------
    private static void populateAccounts(ArrayList<Account> tusAccounts, ArrayList<Customer> tusCustomer) {
        LocalDate newDate = LocalDate.now();
        tusCustomer.add(new Customer("Thiago", "Parzanini", "0871234567", new Address("20 New Street", "Shannon", "Clare", "V14ABCD"), 1));
        tusCustomer.add(new Customer("Michelle", "Parzanini", "0876234567", new Address("15 Old Street", "Shannon", "Clare", "V14ABED"), 2));
        tusCustomer.add(new Customer("Penelope", "Parzanini", "0854234567", new Address("34 That Street", "limerick", "Clare", "V15ABCD"), 3));
        tusCustomer.add(new Customer("Lisa", "Parzanini", "0871230767", new Address("35 Somewhere", "Ennis", "Clare", "V16ABCD"), 4));

        tusAccounts.add(new DepositAccount(new Customer("Thiago", "Parzanini", "0871234567", new Address("20 New Street", "Shannon", "Clare", "V14ABCD"), 1), 300, newDate));
        tusAccounts.add(new DepositAccount(new Customer("Michelle", "Parzanini", "0876234567", new Address("15 Old Street", "Shannon", "Clare", "V14ABED"), 2), 400, newDate));
        tusAccounts.add(new DepositAccount(new Customer("Penelope", "Parzanini", "0854234567", new Address("34 That Street", "limerick", "Clare", "V15ABCD"), 3), 500, newDate));
        tusAccounts.add(new DepositAccount(new Customer("Lisa", "Parzanini", "0871230767", new Address("35 Somewhere", "Ennis", "Clare", "V16ABCD"), 4), 600, newDate));
        tusAccounts.add(new CurrentAccount(new Customer("Thiago", "Parzanini", "0871904567", new Address("20 New Street", "Shannon", "Clare", "V14ABCD"), 1), 10000, newDate, 3000));
        tusAccounts.add(new CurrentAccount(new Customer("Michelle", "Parzanini", "0871234567", new Address("15 Old Street", "Shannon", "Clare", "V14ABED"), 2), 2000, newDate, 500));
        tusAccounts.add(new CurrentAccount(new Customer("Penelope", "Parzanini", "0851234567", new Address("34 That Street", "limerick", "Clare", "V15ABCD"), 3), 2500, newDate, 100));
        tusAccounts.add(new CurrentAccount(new Customer("Lisa", "Parzanini", "0871674567", new Address("35 Somewhere", "Ennis", "Clare", "V16ABCD"), 4), 3000, newDate, 400));

    }
    private static void populateStaff(ArrayList<BankStaff> tusBankStaff) {
        tusBankStaff.add(new BankStaff("Alexandra", "Parzanini", "0838940092", new Address("15 New Street", "Shannon", "Clare", "V14ABCD"), 1, 50000.00, Position.BANKMANAGER));
        tusBankStaff.add(new BankStaff("Julia", "Parzanini", "084985094", new Address("22 Old Street", "Shannon", "Clare", "V14ABED"), 2, 40000.00, Position.BANKOFFICER));
        tusBankStaff.add(new BankStaff("Vinicius", "Parzanini", "0837456093", new Address("56 That Street", "limerick", "Clare", "V15ABCD"), 3, 30000.00, Position.BANKOFFICER));

    }
    // ------------------------------------------- Customer Methods --------------------------------------------------
    private static void checkBalance(ArrayList<Account> tusAccounts) {
        Scanner input = new Scanner(System.in);
        // Get the customer's ID from the user and his name for the welcome message
        System.out.println("Please enter your Customer ID to proceed:");
        int customerId = input.nextInt();
        String customerName = null;
        // Find accounts associated with the customer ID
        ArrayList<Account> customerAccounts = new ArrayList<>();
        for (Account a : tusAccounts) {
            if (customerId == a.getCustID().getCustID()) {
                customerAccounts.add(a);
                customerName = a.getCustID().getFirstName() + " " + a.getCustID().getLastName();
            }
        }
        // Check if the customer has any accounts
        if (!customerAccounts.isEmpty()) {
            // Display customer's accounts
            System.out.println("Welcome to Tus Bank, " + customerName);
            System.out.println("Your accounts:");
            for (Account account : customerAccounts) {
                System.out.println("Type: " + account.getClass().getSimpleName() + " | Account Number: " + account.getId());
            }
            // Get the account ID from the user
            System.out.println("Please Enter the Account Number you want to check the balance:");
            int accountId = input.nextInt();
        // Variable to store the selected account
            Account selectedAccount = null;
            for (Account account : customerAccounts) {
                if (accountId == account.getId()) {
                    selectedAccount = account;
                    break;
                }
            }

            // Check if the selected account was found
            if (selectedAccount != null) {
                System.out.println("Your balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance());
            } else {
                System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.");
            }
        } else {
            System.out.println("Customer with ID " + customerId + " does not have any accounts.");
        }
    }




    private static void withdrawMoney(ArrayList<Account> tusAccounts) {
        System.out.println("Please enter your Account ID to proceed.");
        Scanner input = new Scanner(System.in);
        int customerId = input.nextInt();
        String customerName = null;
        // Find accounts associated with the customer ID
        ArrayList<Account> customerAccounts = new ArrayList<>();
        for (Account a : tusAccounts) {
            if (customerId == a.getCustID().getCustID()) {
                customerAccounts.add(a);
                customerName = a.getCustID().getFirstName() + " " + a.getCustID().getLastName();
            }
        }
        // Check if the customer has any accounts
        if (!customerAccounts.isEmpty()) {
            // Display customer's accounts
            System.out.println("Welcome to Tus Bank, " + customerName );
            System.out.println("Your accounts:");

            for (Account account : customerAccounts) {
                System.out.println("Type: " + account.getClass().getSimpleName() + " | Account Number: " + account.getId());
            }

            // Get the account ID from the user
            System.out.println("Please enter the Account Number you want to withdraw money:");
            int accountId = input.nextInt();
            // Find the account
            Account selectedAccount = null;
            for (Account account : customerAccounts) {
                if (accountId == account.getId()) {
                    selectedAccount = account;
                    break;
                }
            }
            // Check if the selected account was found
            if (selectedAccount != null) {
                System.out.println("How much do you want to withdraw?");
                double withdraw = input.nextDouble();
                selectedAccount.setBalance(selectedAccount.getBalance() - withdraw);
                System.out.println("Your new balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance());
            } else {
                System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.");

            }
        } else {
            System.out.println("Customer with ID " + customerId + " does not have any accounts.");

        }
    }
            private static void depositMoney(ArrayList<Account> tusAccounts) {
        Scanner input = new Scanner(System.in);
        // Get the customer's ID from the user and his name for the welcome message
        System.out.println("Please enter your Customer ID to proceed:");
        int customerId = input.nextInt();
        String customerName = null;
        // Find accounts associated with the customer ID
        ArrayList<Account> customerAccounts = new ArrayList<>();
        for (Account a : tusAccounts) {
            if (customerId == a.getCustID().getCustID()) {
                customerAccounts.add(a);
                customerName = a.getCustID().getFirstName() + " " + a.getCustID().getLastName();
            }
        }
        // Check if the customer has any accounts
        if (!customerAccounts.isEmpty()) {
            // Display customer's accounts
            System.out.println("Welcome to Tus Bank, " + customerName );
            System.out.println("Your accounts:");

            for (Account account : customerAccounts) {
                System.out.println("Type: " + account.getClass().getSimpleName() + " | Account Number: " + account.getId());
            }

            // Get the account ID from the user
            System.out.println("Please enter the Account Number you want to use for the deposit:");
            int accountId = input.nextInt();

            // Find the account
            Account selectedAccount = null;
            for (Account account : customerAccounts) {
                if (accountId == account.getId()) {
                    selectedAccount = account;
                    break;
                }
            }
            // Check if the selected account was found
            if (selectedAccount != null) {
                // Get deposit amount from the user
                System.out.println("How much do you want to deposit?");
                double deposit = input.nextDouble();
                selectedAccount.setBalance(selectedAccount.getBalance() + deposit);
                System.out.println("Your new balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance());
            } else {
                System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.");
            }
        } else {
            System.out.println("Customer with ID " + customerId + " does not have any accounts.");
        }
    }

    // ------------------------------------------- Bank Officer Methods --------------------------------------------------
    private static void addNewCustomer(ArrayList<Customer> tusCustomer) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the customer's first name");
        String firstName = input.nextLine();
        System.out.println("Please enter the customer's last name");
        String lastName = input.nextLine();
        System.out.println("Please enter the customer's phone number");
        String phone = input.nextLine();
        System.out.println("Please enter the customer's street");
        String street = input.nextLine();
        System.out.println("Please enter the customer's city");
        String city = input.nextLine();
        System.out.println("Please enter the customer's county");
        String county = input.nextLine();
        System.out.println("Please enter the customer's Eircode");
        String eircode = input.nextLine();
        System.out.println("Please enter the customer's ID"); //Create a method to check if the ID already exists
        int custID = input.nextInt();
        custID = checkCustomerID(custID, tusCustomer);
        Address address = new Address(street, city, county, eircode);
        Customer customer = new Customer(firstName, lastName, phone, address, custID);
        tusCustomer.add(customer);
        System.out.println(customer.toString());
    }

    private static int checkCustomerID(int custID, ArrayList<Customer> tusCustomer) {
        for (Customer c : tusCustomer) {
            if (custID == c.getCustID()) {
                System.out.println("This ID already exists, please enter a new ID");
                Scanner input = new Scanner(System.in);
                custID = input.nextInt();
                checkCustomerID(custID, tusCustomer);


            }

        }
        return custID;
    }


    private static void createNewAccount(ArrayList<Account> tusAccounts, ArrayList<Customer> tusCustomer) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the customer's ID");
        int custID = input.nextInt();
        for (Customer c : tusCustomer) {
            if (custID == c.getCustID()) {
                System.out.println("Please enter the account type to be created (1 - Current Account / 2 - Deposit Account)");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.println("Please enter the account balance");
                    double balance = input.nextDouble();
                    System.out.println("Please enter the overdraft");
                    double overdraft = input.nextDouble();
                    LocalDate newDate = LocalDate.now();
                    CurrentAccount currentAccount = new CurrentAccount(c, balance, newDate, overdraft);
                    tusAccounts.add(currentAccount);
                    System.out.println("Account Linked to Customer:" + c.getCustID() + " " + c.getFirstName() + " " + c.getLastName());
                    System.out.println(currentAccount.toString());
                    System.out.println("Account created successfully");
                } else if (option == 2) {
                    System.out.println("Please enter the account balance");
                    double balance = input.nextDouble();
                    LocalDate newDate = LocalDate.now();
                    DepositAccount depositAccount = new DepositAccount(c, balance, newDate);
                    tusAccounts.add(depositAccount);
                    System.out.println("Account Linked to Customer:" + c.getCustID() + " " + c.getFirstName() + " " + c.getLastName());
                    System.out.println(depositAccount.toString());
                    System.out.println("Account created successfully");
                }
            }
        }
    }
}