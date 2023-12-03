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
        int menuOption, outterMenuOption;

        // ------------------------------------------- Dummy Data --------------------------------------------------
        populateAccounts(tusAccounts, tusCustomer);
        populateStaff(tusBankStaff);

        // ------------------------------------------- Main Menu --------------------------------------------------
        System.out.println("Welcome to Tus Bank\n");
        try {
            do {
                System.out.println("Select \n1 - Customer \n2 - Bank Staff \n0 - Exit\n");
                outterMenuOption = input.nextInt();
                if (outterMenuOption == 1) {
                    try {
                        do {
                            System.out.println("Type the option desired \n1 - Deposit Money \n2 - Withdraw Money \n3 - Check Balance \n0 - Back to Main Menu\n");
                            menuOption = input.nextInt();
                            if (menuOption == 1) {
                                depositMoney(tusAccounts);
                            } else if (menuOption == 2) {
                                withdrawMoney(tusAccounts);
                            } else if (menuOption == 3) {
                                checkBalance(tusAccounts);
                            } else if (menuOption == 0) {
                                System.out.println("Back to Main Menu\n");
                            } else {
                                System.out.println("Invalid option, please enter a valid option.\n");
                            }
                        } while (menuOption != 0);
                    } catch (CustomerDoesNotHaveAccountsException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid amount entered, please enter a valid amount.\n");
                    } catch (Exception InputMismatchException) {
                        System.out.println("Invalid option, please enter a valid option.\n");
                        input.nextLine();
                    }
                } else if (outterMenuOption == 2) {
                    try {
                        do {
                            System.out.println("Type the option desired \n1 - Create New Customer \n2 - Create New Account \n3 - Change AIR(Annual Interest Rate) \n4 - Change overdraft \n5 - List all customers and employees \n6 - List all accounts \n7 - Create new Bank Officer \n0 - Back to Main Menu\n");
                            menuOption = input.nextInt();
                            if (menuOption == 1) {
                                addNewCustomer(tusCustomer, tusBankStaff);
                            } else if (menuOption == 2) {
                                createNewAccount(tusAccounts, tusCustomer, tusBankStaff);
                            } else if (menuOption == 3) {
                                changeAIR(tusAccounts, tusBankStaff);
                            } else if (menuOption == 4) {
                                changeOverdraft(tusAccounts, tusBankStaff);
                            } else if (menuOption == 5) {
                                listAllAccounts(tusCustomer, tusBankStaff);
                            } else if (menuOption == 6) {
                                String position = authenticateStaff(tusBankStaff);
                                if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
                                    for (Account a : tusAccounts) {
                                        System.out.println(a.toString());
                                    }
                                } else {
                                    System.out.println("Access denied.\n");
                                }
                            } else if (menuOption == 7) {
                                addNewBankOfficer(tusBankStaff);
                            } else if (menuOption == 0) {
                                System.out.println("Back to Main Menu\n");
                            } else {
                                System.out.println("Invalid option, please enter a valid option.\n");
                            }
                        } while (menuOption != 0);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid amount entered, please enter a valid amount.\n");
                    } catch (Exception InputMismatchException) {
                        System.out.println("Invalid option, please enter a valid option.\n");
                        input.nextLine();
                    }
                } else if (outterMenuOption == 0) {
                    System.out.println("Thank you for using Tus Bank\n");
                } else {
                    System.out.println("Invalid option, please enter a valid option.\n");
                }
            } while (outterMenuOption != 0);
        } catch (Exception InputMismatchException) {
            System.out.println("Invalid option entered, please enter a valid option.\n");
            input.nextLine();
        }
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
    // Method to find the customer's accounts created to reuse code
    public static ArrayList<Account> idFinder(ArrayList<Account> tusAccounts) throws CustomerDoesNotHaveAccountsException {
        System.out.println("Please enter your Account ID to proceed.\n");
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
            System.out.println("Welcome to Tus Bank, " + customerName + "\n");
            System.out.println("Your accounts:\n");

            for (Account account : customerAccounts) {
                System.out.println("Type: " + account.getClass().getSimpleName() + " | Account Number: " + account.getId() + "\n");
            }
        } else {
            throw new CustomerDoesNotHaveAccountsException("Error : Customer does not exist or does not have any accounts.\n");
        }
        return customerAccounts;
    }

    private static void checkBalance(ArrayList<Account> tusAccounts) throws CustomerDoesNotHaveAccountsException {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> customerAccounts = idFinder(tusAccounts);
        // Get the account ID from the user
        System.out.println("Please Enter the Account Number you want to check the balance:\n");
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
            System.out.println("Your balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance() + "\n");
        } else {
            System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.\n");
        }
    }

    private static void withdrawMoney(ArrayList<Account> tusAccounts) throws CustomerDoesNotHaveAccountsException {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> customerAccounts = idFinder(tusAccounts);
        // Get the account ID from the user
        System.out.println("Please enter the Account Number you want to withdraw money: \n");
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
            System.out.println("How much do you want to withdraw? \n");
            double withdraw = input.nextDouble();
            if (withdraw < 0) {
                throw new IllegalArgumentException();
            }
            // Check if the account is a Current Account, if so, check if the withdraw amount is greater than the balance + overdraft
            if (selectedAccount instanceof CurrentAccount) {
                if (withdraw > selectedAccount.getBalance() + ((CurrentAccount) selectedAccount).getOverdraft()) {
                    System.out.println("You don't have enough funds to withdraw this amount. \n");
                    System.out.println("Your current overdraft is: " + (((CurrentAccount) selectedAccount).getOverdraft() + ((CurrentAccount) selectedAccount).getBalance()) + "\n");
                } else {
                    selectedAccount.setBalance(selectedAccount.getBalance() - withdraw);
                    System.out.println("Your new balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance() + "\n");
                }
            } else {
                if (withdraw > selectedAccount.getBalance()) {
                    System.out.println("You don't have enough funds to withdraw this amount.\n");
                } else {
                    selectedAccount.setBalance(selectedAccount.getBalance() - withdraw);
                    System.out.println("Your new balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance() + "\n");
                }
            }
        } else {
            System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.\n");
        }
    }

    private static void depositMoney(ArrayList<Account> tusAccounts) throws CustomerDoesNotHaveAccountsException {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> customerAccounts = idFinder(tusAccounts);
        // Get the account ID from the user
        System.out.println("Please enter the Account Number you want to use for the deposit:\n");
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
            System.out.println("How much do you want to deposit?\n");
            double deposit = input.nextDouble();
            if (deposit < 0) {
                throw new IllegalArgumentException();
            }
            selectedAccount.setBalance(selectedAccount.getBalance() + deposit);
            System.out.println("Your new balance for Account Number " + selectedAccount.getId() + " is: " + selectedAccount.getBalance() + "\n");
        } else {
            System.out.println("Account with Account Number " + accountId + " not found. Please enter a valid Account Number.\n");
        }
    }

    // ------------------------------------------- Bank Officer Methods --------------------------------------------------
    //Method to add a new customer
    private static void addNewCustomer(ArrayList<Customer> tusCustomer, ArrayList<BankStaff> tusBankStaff) {
        String position = authenticateStaff(tusBankStaff);
        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
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
            System.out.println("Please enter the customer's ID");
            int custID = input.nextInt();
            custID = checkCustomerID(custID, tusCustomer);
            Address address = new Address(street, city, county, eircode);
            Customer customer = new Customer(firstName, lastName, phone, address, custID);
            tusCustomer.add(customer);
            System.out.println(customer.toString());
        } else {
            System.out.println("Access denied.\n");
        }
    }

    //Method to check if the ID already exists
    private static int checkCustomerID(int custID, ArrayList<Customer> tusCustomer) {
        for (Customer c : tusCustomer) {
            if (custID == c.getCustID()) {
                System.out.println("This ID already exists, please enter a new ID\n");
                Scanner input = new Scanner(System.in);
                custID = input.nextInt();
                checkCustomerID(custID, tusCustomer);
            }
        }
        return custID;
    }

    //Method to create a new account
    private static void createNewAccount(ArrayList<Account> tusAccounts, ArrayList<Customer> tusCustomer, ArrayList<BankStaff> tusBankStaff) {
        Scanner input = new Scanner(System.in);
        String position = authenticateStaff(tusBankStaff);
        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
            System.out.println("Please enter the customer's ID\n");
            int custID = input.nextInt();
            for (Customer c : tusCustomer) {
                if (custID == c.getCustID()) {
                    System.out.println("Please enter the account type to be created (1 - Current Account / 2 - Deposit Account)\n");
                    int option = input.nextInt();
                    if (option == 1) {
                        System.out.println("Please enter the account balance\n");
                        double balance = input.nextDouble();
                        if (balance < 0) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println("Please enter the overdraft\n");
                        double overdraft = input.nextDouble();
                        if (overdraft < 0) {
                            throw new IllegalArgumentException();
                        }
                        LocalDate newDate = LocalDate.now();
                        CurrentAccount currentAccount = new CurrentAccount(c, balance, newDate, overdraft);
                        tusAccounts.add(currentAccount);
                        System.out.println("Account Linked to Customer:" + c.getCustID() + " " + c.getFirstName() + " " + c.getLastName() + "\n");
                        System.out.println(currentAccount.toString());
                        System.out.println("Account created successfully\n");
                    } else if (option == 2) {
                        System.out.println("Please enter the account balance\n");
                        double balance = input.nextDouble();
                        LocalDate newDate = LocalDate.now();
                        DepositAccount depositAccount = new DepositAccount(c, balance, newDate);
                        tusAccounts.add(depositAccount);
                        System.out.println("Account Linked to Customer:" + c.getCustID() + " " + c.getFirstName() + " " + c.getLastName() + "\n");
                        System.out.println(depositAccount.toString());
                        System.out.println("Account created successfully\n");
                    }
                }
            }
        } else {
            System.out.println("Access denied.\n");
        }
    }

    //Method to change the AIR
    private static void changeAIR(ArrayList<Account> tusAccounts, ArrayList<BankStaff> tusBankStaff) {
        Scanner input = new Scanner(System.in);
        String position = authenticateStaff(tusBankStaff);
        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
            System.out.println("1 - Change AIR for Current Accounts \n2 - Change AIR for Deposit Accounts\n");
            int option = input.nextInt();
            if (option == 1) {
                System.out.println("Please enter the new AIR\n");
                double air = input.nextDouble();
                CurrentAccount.setAir(air);
                System.out.println("AIR changed successfully to " + air + "\n");
            } else if (option == 2) {
                System.out.println("Please enter the new AIR\n");
                double air = input.nextDouble();
                DepositAccount.setAir(air);
                System.out.println("AIR changed successfully to " + air + "\n");
            } else {
                System.out.println("Invalid option, please enter a valid option.\n");

            }
        } else {
            System.out.println("Access denied.\n");
        }
    }

    //Method to change the overdraft
    private static void changeOverdraft(ArrayList<Account> tusAccounts, ArrayList<BankStaff> tusBankStaff) {
        Scanner input = new Scanner(System.in);
        String position = authenticateStaff(tusBankStaff);

        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
            System.out.println("Please enter the new overdraft:");
            double overdraft = input.nextDouble();

            if (overdraft < 0) {
                throw new IllegalArgumentException("Overdraft cannot be negative.");
            }
            System.out.println("Please enter the account ID:");
            int accountId = input.nextInt();
            String message = null;

            for (Account a : tusAccounts) {
                if (accountId == a.getId() && a instanceof CurrentAccount) {
                    ((CurrentAccount) a).setOverdraft(overdraft);
                    System.out.println("Account: " + a.getId() + " Overdraft changed successfully to " + overdraft + "\n");
                    return;
                } else {
                    message = "This account is not a Current Account.";
                }
            }

            if (message != null) {
                System.out.println(message + "\n");
            } else {
                System.out.println("Account not found.\n");
            }
        } else {
            System.out.println("Access denied.\n");
        }
    }


    //Method to authenticate the staff
    private static String authenticateStaff(ArrayList<BankStaff> tusBankStaff) {
        Scanner input = new Scanner(System.in);
        String staffName = null;
        String position = "CUSTOMER";
        System.out.println("Please enter your Staff ID\n");
        int id = input.nextInt();
        for (BankStaff b : tusBankStaff) {
            if (id == b.getStaffID()) {
                staffName = b.getFirstName() + " " + b.getLastName() + " - " + b.getPosition();
                position = b.getPosition().toString();
            }
        }
        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
            System.out.println(staffName + " logged in successfully\n");
        }
        return position;
    }

    //Method to add a new Bank Officer
    private static void addNewBankOfficer(ArrayList<BankStaff> tusBankStaff) {
        String position = authenticateStaff(tusBankStaff);
        if (position.equals("BANKMANAGER")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Bank Officer's first name");
            String firstName = input.nextLine();
            System.out.println("Please enter the Bank Officer's last name");
            String lastName = input.nextLine();
            System.out.println("Please enter the Bank Officer's phone number");
            String phone = input.nextLine();
            System.out.println("Please enter the Bank Officer's street");
            String street = input.nextLine();
            System.out.println("Please enter the Bank Officer's city");
            String city = input.nextLine();
            System.out.println("Please enter the Bank Officer's county");
            String county = input.nextLine();
            System.out.println("Please enter the Bank Officer's Eircode");
            String eircode = input.nextLine();
            System.out.println("Please enter the Bank Officer's ID");
            int staffID = input.nextInt();
            checkOfficerID(staffID, tusBankStaff);
            System.out.println("Please enter the Bank Officer's salary");
            double salary = input.nextDouble();
            if (salary < 0) {
                throw new IllegalArgumentException();
            }
            Position position2 = positionCheck();
            Address address = new Address(street, city, county, eircode);
            BankStaff bankStaff = new BankStaff(firstName, lastName, phone, address, staffID, salary, position2);
            tusBankStaff.add(bankStaff);
            System.out.println(bankStaff);
        } else {
            System.out.println("Access denied.\n");
        }
    }

    private static void listAllAccounts(ArrayList<Customer> tusCustomer, ArrayList<BankStaff> tusBankStaff) {
        String position = authenticateStaff(tusBankStaff);
        if (position.equals("BANKMANAGER") || position.equals("BANKOFFICER")) {
            System.out.println("List of customers: \n");
            for (Customer c : tusCustomer) {
                System.out.println(c.toString() + "\n");
            }
            System.out.println("List of employees: \n");
            for (BankStaff b : tusBankStaff) {
                System.out.println(b.toString() + "\n");
            }
        } else {
            System.out.println("Access denied.\n");
        }

    }

    private static Position positionCheck() {
        System.out.println("Please enter the Bank Officer's position: \n1 - BANKMANAGER \n2 - BANKOFFICER");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        Position position = null;
        if (option == 1) {
            position = Position.BANKMANAGER;
        } else if (option == 2) {
            position = Position.BANKOFFICER;
        } else {
            System.out.println("Invalid option, please enter a valid option.\n");
            positionCheck();
        }
        return position;
    }

    private static void checkOfficerID(int staffID, ArrayList<BankStaff> tusBankStaff) {
        for (BankStaff b : tusBankStaff) {
            if (staffID == b.getStaffID()) {
                System.out.println("This ID already exists, please enter a new ID\n");
                Scanner input = new Scanner(System.in);
                staffID = input.nextInt();
                checkOfficerID(staffID, tusBankStaff);
            }
        }
    }
}

