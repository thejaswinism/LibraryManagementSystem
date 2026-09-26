package main;

import java.util.Scanner;

import model.Book;
import model.BookCategory;
import model.Borrowable;
import model.Librarian;
import model.Person;
import model.Student;
import repository.LibraryRepository;
import service.LibraryService;

public class LibraryApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);

        addSampleBooks(service);
        addSampleStudents(service);

        boolean running = true;

        System.out.println("====================================================");
        System.out.println("       REVA UNIVERSITY LIBRARY MANAGEMENT SYSTEM");
        System.out.println("====================================================");

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    service.displayBooks();
                    break;

                case 2:
                    searchBook(service);
                    break;

                case 3:
                    registerStudent(service);
                    break;

                case 4:
                    displayStudents(repository);
                    break;

                case 5:
                    borrowBook(service);
                    break;

                case 6:
                    returnBook(service);
                    break;

                case 7:
                    calculateFine(service);
                    break;

                case 8:
                    addNewBook(service);
                    break;

                case 9:
                    service.displayStatistics();
                    break;

                case 10:
                    demonstrateOOP();
                    break;

                case 0:
                    running = false;
                    System.out.println("\nThank you for using");
                    System.out.println("REVA University Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n-------------------- MAIN MENU --------------------");
        System.out.println("1. View All Books");
        System.out.println("2. Search Book");
        System.out.println("3. Register REVA Student");
        System.out.println("4. View Registered Students");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Calculate Fine");
        System.out.println("8. Add New Book");
        System.out.println("9. Library Statistics");
        System.out.println("10. OOP Demonstration");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------------------");
    }

    private static void addSampleBooks(LibraryService service) {

        service.addBook(new Book(
                "B101",
                "Java Programming",
                "Herbert Schildt",
                BookCategory.PROGRAMMING));

        service.addBook(new Book(
                "B102",
                "Data Structures and Algorithms",
                "Thomas Cormen",
                BookCategory.COMPUTER_SCIENCE));

        service.addBook(new Book(
                "B103",
                "Bioinformatics Algorithms",
                "Phillip Compeau",
                BookCategory.BIOINFORMATICS));

        service.addBook(new Book(
                "B104",
                "Statistical Methods",
                "George Snedecor",
                BookCategory.STATISTICS));

        service.addBook(new Book(
                "B105",
                "Database Management Systems",
                "Raghu Ramakrishnan",
                BookCategory.DATABASES));

        service.addBook(new Book(
                "B106",
                "Python for Data Science",
                "Wes McKinney",
                BookCategory.DATA_SCIENCE));
    }

    private static void addSampleStudents(LibraryService service) {

        service.registerStudent(new Student(
                "Thejaswini S M",
                "R24SA043",
                "B.Sc. BSTCs",
                5));

    }

    private static void searchBook(LibraryService service) {

        System.out.print("Enter book title or author: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Search cannot be empty.");
            return;
        }

        service.searchBook(keyword);
    }

    private static void registerStudent(LibraryService service) {

        System.out.println("\n--- REVA STUDENT REGISTRATION ---");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter SRN: ");
        String srn = scanner.nextLine();

        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        System.out.print("Enter semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(name, srn, course, semester);

        service.registerStudent(student);

        System.out.println("Student registered successfully!");
    }

    private static void displayStudents(LibraryRepository repository) {

        System.out.println("\n--------- REGISTERED REVA STUDENTS ---------");

        for (Student student : repository.getStudents()) {
            System.out.println(student);
        }
    }

    private static void borrowBook(LibraryService service) {

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter Student SRN: ");
        String studentId = scanner.nextLine();

        boolean success = service.borrowBook(bookId, studentId);

        if (success) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Unable to borrow book.");
            System.out.println("Check the Book ID, SRN, or book availability.");
        }
    }

    private static void returnBook(LibraryService service) {

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter Student SRN: ");
        String studentId = scanner.nextLine();

        boolean success = service.returnBook(bookId, studentId);

        if (success) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Unable to return book.");
        }
    }

    private static void calculateFine(LibraryService service) {

        System.out.print("Enter number of days late: ");
        int daysLate = scanner.nextInt();
        scanner.nextLine();

        double fine = service.calculateFine(daysLate);

        System.out.printf("Library Fine: Rs. %.2f%n", fine);
    }

    private static void addNewBook(LibraryService service) {

        System.out.println("\n--- ADD NEW BOOK ---");

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        BookCategory category = selectCategory();

        Book book = new Book(bookId, title, author, category);

        service.addBook(book);

        System.out.println("Book added successfully to REVA University Library!");
    }

    private static BookCategory selectCategory() {

        BookCategory[] categories = BookCategory.values();

        System.out.println("\nSelect Book Category:");

        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        System.out.print("Enter category number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > categories.length) {
            System.out.println("Invalid category. Using COMPUTER_SCIENCE.");
            return BookCategory.COMPUTER_SCIENCE;
        }

        return categories[choice - 1];
    }

    private static void demonstrateOOP() {

        System.out.println("\n========== OOP DEMONSTRATION ==========");

        Person student = new Student(
                "Demo Student",
                "R24DEMO01",
                "B.Sc. BSTCs",
                5);

        Person librarian = new Librarian(
                "REVA Library Staff",
                "LIB001",
                "REVA Central Library");

        student.displayRole();
        librarian.displayRole();

        Borrowable borrower = new Student(
                "Borrowing Student",
                "R24DEMO02",
                "B.Sc. BSTCs",
                5);

        borrower.borrowBook();

        System.out.println("Interface reference successfully used.");
        System.out.println("Dynamic binding successfully demonstrated.");
        System.out.println("========================================");
    }
}