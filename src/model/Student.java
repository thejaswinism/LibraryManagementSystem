package model;

public class Student extends Person implements Borrowable {

    private String course;
    private int semester;
    private int borrowedBooks;

    private static int totalStudents = 0;

    // Default constructor
    public Student() {
        super();
        this.course = "Not Assigned";
        this.semester = 1;
        this.borrowedBooks = 0;
        totalStudents++;
    }

    // Parameterized constructor
    public Student(String name, String id, String course, int semester) {
        super(name, id);
        this.course = course;
        this.semester = semester;
        this.borrowedBooks = 0;
        totalStudents++;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: REVA University Student");
    }

    @Override
    public void borrowBook() {
        borrowedBooks++;
    }

    @Override
    public void returnBook() {
        if (borrowedBooks > 0) {
            borrowedBooks--;
        }
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Course: " + course
                + ", Semester: " + semester
                + ", Borrowed Books: " + borrowedBooks;
    }
}