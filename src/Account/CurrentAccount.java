package Account;

import Account.Account;
import Person.Customer;

import java.time.LocalDate;

public class CurrentAccount extends Account {

    private static double air = 0.005;
    private double overdraft;

    public CurrentAccount(Customer custID, double balance, LocalDate dataCreated, double overdraft) {
        super(custID, balance, dataCreated);

        this.overdraft = overdraft;
    }
    public double getAir() {
        return air;
    }

    public void setAir(double air) {
        this.air = air;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }


@Override
    public String toString() {
        return String.format("Account ID: %d\nCustomer ID: %d\nBalance: %.2f\nDate Created: %s\nAnnual Interest Rate: %.2f\nOverdraft: %.2f\n", getId(), getCustID().getCustID(), getBalance(), getDataCreated(), getAir(), getOverdraft());
    }



}
