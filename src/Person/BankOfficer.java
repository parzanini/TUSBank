package Person;

import Person.BankStaff;


public class BankOfficer extends BankStaff {
    private Position position=Position.BANKOFFICER;

    public BankOfficer(String name, String lastName, String phone,Address address, int staffID, double salary, Position position) {
        super(name, lastName, phone,address, staffID, salary);
        this.position=position;
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPosition: %s", position);
    }
}
