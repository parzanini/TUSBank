package Account;

import Person.*;

import java.time.LocalDate;

public abstract class Account {

    private int id;
    private Customer custID;
    private double balance;
    private LocalDate dataCreated;
    private static int nextID = 1;

    public Account(Customer custID, double balance, LocalDate dataCreated) {
        this.id=getNextID();
        this.custID = custID;
        this.balance = balance;
        this.dataCreated = dataCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustID() {
        return custID;
    }

    public void setCustID(Customer custID) {
        this.custID = custID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(LocalDate dataCreated) {
        this.dataCreated = dataCreated;
    }

    public static void setNextID(int nextID) {
        Account.nextID = nextID;
    }

    private static int getNextID() {
        return nextID++;
    }

    @Override
    public String toString() {
        return String.format("Account ID: %d\nOwner: %s\nBalance: %.2f\nDate Created: %s ", getId(), getCustID().toString(), getBalance(), getDataCreated());
    }
}
