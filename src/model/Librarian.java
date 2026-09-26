package model;

public class Librarian extends Person {

    private String department;

    // Default constructor
    public Librarian() {
        super();
        this.department = "REVA Central Library";
    }

    // Parameterized constructor
    public Librarian(String name, String id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: REVA University Librarian");
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Department: " + department;
    }
}