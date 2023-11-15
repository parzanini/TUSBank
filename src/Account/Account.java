package Account;

import Person.Customer;

import java.time.LocalDate;

public abstract class Account {

    private int id;
    private Customer custID;
    private double balance;
    private LocalDate dataCreated;

    public Account(Customer custID, double balance, LocalDate dataCreated) {
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

    @Override
    public String toString() {
        return String.format("Account ID: %d\nCustomer ID: %d\nBalance: %.2f\nDate Created: %s\n", id, getCustID().getCustID(), balance, dataCreated);
    }
}
