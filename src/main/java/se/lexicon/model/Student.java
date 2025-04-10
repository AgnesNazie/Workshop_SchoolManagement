package se.lexicon.model;

public class Student {
    //fields
    private static int sequencer = 0;
    private int id;
    private String name;
    private String email;
    private String address;
    //constructor

    public Student(String name, String email, String address) {
        this.id = ++sequencer;
        setName(name);
        setEmail(email);
        setAddress(address);
    }
    //getter for id

    public int getId() {
        return id;
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
}
