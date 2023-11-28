package Person;

public class Address {

    private String street;
    private String city;
    private String county;
    private String eircode;

    public Address(String street, String city, String county, String eircode){
        this.street=street;
        this.city=city;
        this.county=county;
        this.eircode=eircode;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street=street;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }

    public String getState(){
        return county;
    }

    public void setState(String state){
        this.county=state;
    }

    public String getZipCode(){
        return eircode;
    }

    public void setZipCode(String zipCode){
        this.eircode=zipCode;
    }

    @Override
    public String toString(){
        return String.format("Address: %s\nCity: %s\nCounty: %s\nEircode: %s", street, city, county, eircode);

    }
}

