package Person;

import Person.Person;

public class BankStaff extends Person {

    private int staffID;
    private double salary;

    public BankStaff(String name, String lastName, String phone,Address address, int staffID, double salary) {
        super(name, lastName, phone,address);
        this.staffID = staffID;
        this.salary = salary;
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

    @Override
        public String toString() {
            return super.toString() + String.format("\nStaff ID: %d\nSalary: %.2f", staffID, salary);
        }

}
