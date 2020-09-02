package model;

public class ContactData {
    private String id;
    private String firstName;
    private String lastName;
    private String  phone;
    private String  email;
    private String  address;
    private String  city;
    private String  state;
    private String  zipcode;

    public String getId() {
        return id;
    }

    public ContactData withId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ContactData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public ContactData withState(String state) {
        this.state = state;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public ContactData setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

}
