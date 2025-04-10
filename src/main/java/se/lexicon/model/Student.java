package se.lexicon.model;

public class Student {
    //fields
    private int id;
    private String name;
    private String email;
    private String address;
    //constructor

    public Student(int id, String name, String email, String address) {
        this.id = id;
        setName(name);
        setEmail(email);
        setAddress(address);
    }
    //getter for id

    public int getId() {
        return id;
    }

    //setter for id
    public void setId(int id) {
        this.id = id;
    }
    //getter for name

    public String getName() {
        return name;
    }
    //setter for name

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }
    //getter for email

    public String getEmail() {
        return email;
    }
    //setter for email

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email cannot be null or empty");
        this.email = email;
    }
    //getter for address

    public String getAddress() {
        return address;
    }
    //setter for address

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty())
            throw new IllegalArgumentException("Address cannot be null or empty");
        this.address = address;
    }

    //to string method
    @Override
    public String toString() {
        return "Student ID: " + id +
                ", Name='" + name +
                ", email='" + email +
                ", address='" + address;
    }
}

