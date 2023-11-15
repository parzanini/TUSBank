package Person;

import Person.Person;

public class Customer extends Person {

    private int custID;

    public Customer(String name, String address, String phone, int custID) {
        super(name, address, phone);
        this.custID = custID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d\nName: %s\nAddress: %s\nPhone: %s\n", custID, getFirstName(), getAddress(), getLastName());
    }
}
