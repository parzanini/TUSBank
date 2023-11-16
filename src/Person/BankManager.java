package Person;

import Person.BankStaff;

public class BankManager extends BankStaff {

    private Position position;


    public BankManager(String name, String lastName, String phone,Address address, int staffID, double salary, Position position) {
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
