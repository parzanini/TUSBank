package Person;

public abstract class Person {

    private String firstName;
    private String lastName;

    private String phone;
    private Address address;

    public Person(String name, String lastName, String phone,Address address) {
        this.firstName = name;
        this.lastName = lastName;

        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return String.format("Customer name: %s %s\nPhone: %s\nAddress: %s", firstName, lastName, phone, address.toString());
    }
}
