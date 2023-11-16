package Account;


import Person.*;

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
        DepositAccount.air = air;
    }

@Override
    public String toString() {
        return super.toString() + String.format("Annual Interest Rate: %.2f\n", getAir());
    }



}
