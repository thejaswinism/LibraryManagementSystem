package service;

import java.util.List;

import model.Book;
import model.BookCategory;
import model.Student;
import repository.LibraryRepository;

public class LibraryService {

    private LibraryRepository repository;
    private FineCalculator fineCalculator;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
        this.fineCalculator = new FineCalculator();
    }

    // Add a book to REVA University Library
    public void addBook(Book book) {
        repository.addBook(book);
    }

    // Register a REVA student
    public void registerStudent(Student student) {
        repository.addStudent(student);
    }

    // Display all books
    public void displayBooks() {

        List<Book> books = repository.getBooks();

        System.out.println("\nREVA UNIVERSITY LIBRARY - BOOK COLLECTION");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-8s %-35s %-25s %-20s %-10s%n",
                "ID", "Title", "Author", "Category", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search using keyword
    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : repository.getBooks()) {

            if (book.matches(keyword)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for: " + keyword);
        }
    }

    // Overloaded search method
    public void searchBook(String keyword, BookCategory category) {

        boolean found = false;

        for (Book book : repository.getBooks()) {

            if (book.matches(keyword, category)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    // Borrow a book
    public boolean borrowBook(String bookId, String studentId) {

        Book book = repository.findBook(bookId);
        Student student = repository.findStudent(studentId);

        if (book == null || student == null) {
            return false;
        }

        if (!book.isAvailable()) {
            return false;
        }

        book.setAvailable(false);
        student.borrowBook();

        return true;
    }

    // Return a book
    public boolean returnBook(String bookId, String studentId) {

        Book book = repository.findBook(bookId);
        Student student = repository.findStudent(studentId);

        if (book == null || student == null) {
            return false;
        }

        if (book.isAvailable()) {
            return false;
        }

        book.setAvailable(true);
        student.returnBook();

        return true;
    }

    // Calculate fine
    public double calculateFine(int daysLate) {
        return fineCalculator.calculateFine(daysLate);
    }

    // Final method
    // Final because library statistics should not be overridden by subclasses.
    public final void displayStatistics() {

        System.out.println("\n========== REVA LIBRARY STATISTICS ==========");
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Total Registered Students: "
                + Student.getTotalStudents());
        System.out.println("=============================================");
    }
}