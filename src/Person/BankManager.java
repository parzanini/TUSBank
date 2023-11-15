package Person;

import Person.BankStaff;

public class BankManager extends BankStaff {

    private Position position=Position.BANKMANAGER;


    public BankManager(String name, String address, String phone, int staffID, double salary, Position position) {
        super(name, address, phone, staffID, salary);
        this.position=position;

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
