package Person;

import Person.Person;

public class BankStaff extends Person {

    private int staffID;
    private double salary;

    public BankStaff(String name, String address, String phone, int staffID, double salary) {
        super(name, address, phone);
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
            return String.format("Staff ID: %d\nName: %s\nAddress: %s\nPhone: %s\nSalary: %.2f\n", staffID, getFirstName(), getAddress(), getLastName(), salary);
        }

}
