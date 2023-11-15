package Person;

import Person.BankStaff;


public class BankOfficer extends BankStaff {
    private Position position=Position.BANKOFFICER;

    public BankOfficer(String name, String address, String phone, int staffID, double salary, Position position) {
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
