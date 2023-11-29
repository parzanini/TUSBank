package Person;

import Person.BankStaff;

public class BankManager extends BankStaff {

    public BankManager(String name, String lastName, String phone,Address address, int staffID, double salary, Position position) {
        super(name, lastName, phone,address, staffID, salary,position);
    }

}
