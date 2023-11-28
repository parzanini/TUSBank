package Person;

import Person.Person;

public class BankStaff extends Person {

    private int staffID;
    private double salary;
    private Position position;



    public BankStaff(String name, String lastName, String phone, Address address, int staffID, double salary, Position position) {
        super(name, lastName, phone,address);
        this.staffID = staffID;
        this.salary = salary;
        this.position = position;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
        public String toString() {
            return String.format("Staff name: %s %s\nPhone: %s\nAddress: %s\nStaff ID: %d\nSalary: %.2f\nPosition: %s", getFirstName(), getLastName(), getPhone(), getAddress().toString(), getStaffID(), getSalary(), getPosition());
        }

}
