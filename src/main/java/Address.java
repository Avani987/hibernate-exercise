package main.java;

public class Address {
    int streetNo;
    String location;
    String state;

    public Address(int streetNo, String location, String state) {
        this.streetNo = streetNo;
        this.location = location;
        this.state = state;
    }

    public Address() {
        this.streetNo=0;
        this.location=null;
        this.state=null;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
