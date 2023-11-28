package Person;

import Person.Person;

public class Customer extends Person {

    private int custID;

    public Customer(String name,String lastName , String phone,Address address, int custID) {
        super(name, lastName, phone,address);

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
        return super.toString() + String.format("Customer ID: %d\n", custID);
    }
}
