package Person;

import Person.BankStaff;

public class BankManager extends BankStaff {

    private static Position position=Position.BANKMANAGER;


    public BankManager(String name, String lastName, String phone,Address address, int staffID, double salary, Position position) {
        super(name, lastName, phone,address, staffID, salary,position);



    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
