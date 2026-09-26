package model;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private BookCategory category;
    private boolean available;

    private static int totalBooks = 0;

    public static final int MAX_BORROW_DAYS = 14;

    // Default constructor
    public Book() {
        this("B000", "Unknown Book", "Unknown Author",
                BookCategory.COMPUTER_SCIENCE);
    }

    // Parameterized constructor
    public Book(String bookId, String title, String author,
                BookCategory category) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;

        totalBooks++;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    // Method overloading
    public boolean matches(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase())
                || author.toLowerCase().contains(keyword.toLowerCase());
    }

    public boolean matches(String keyword, BookCategory category) {
        return matches(keyword) && this.category == category;
    }

    @Override
    public String toString() {
        return String.format(
                "%-8s %-35s %-25s %-20s %-10s",
                bookId,
                title,
                author,
                category,
                available ? "Available" : "Borrowed"
        );
    }
}