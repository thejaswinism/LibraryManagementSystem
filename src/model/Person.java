package model;

public abstract class Person {

    private String name;
    private String id;

    // Default constructor
    public Person() {
        this("Unknown", "NA");
    }

    // Parameterized constructor
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for ID
    public void setId(String id) {
        this.id = id;
    }

    // Abstract method
    public abstract void displayRole();

    // toString method
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}