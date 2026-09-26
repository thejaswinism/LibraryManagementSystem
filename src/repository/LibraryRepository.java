package repository;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Student;

public class LibraryRepository {

    private List<Book> books;
    private List<Student> students;

    public LibraryRepository() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a REVA student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Get all books
    public List<Book> getBooks() {
        return books;
    }

    // Get all students
    public List<Student> getStudents() {
        return students;
    }

    // Find a book using Book ID
    public Book findBook(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }

        return null;
    }

    // Find a student using SRN
    public Student findStudent(String srn) {

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(srn)) {
                return student;
            }
        }

        return null;
    }
}