package Account;

import Account.Account;
import Person.Customer;

import java.time.LocalDate;

public class DepositAccount extends Account {

    private static double air = 0.02;

    public DepositAccount(Customer custID, double balance, LocalDate dataCreated) {
        super(custID, balance, dataCreated);

    }


    public double getAir() {
        return air;
    }

    public void setAir(double air) {
        this.air = air;
    }

@Override
    public String toString() {
        return String.format("Account ID: %d\nCustomer ID: %d\nBalance: %.2f\nDate Created: %s\nAnnual Interest Rate: %.2f\n", getId(), getCustID().getCustID(), getBalance(), getDataCreated(), getAir());
    }



}
