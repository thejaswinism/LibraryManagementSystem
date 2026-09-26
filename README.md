# REVA University Library Management System

## Project Overview

The REVA University Library Management System is a console-based Java application developed as a mini project for the Java Programming course.

The system is designed to manage books, REVA University students, borrowing and returning of books, library fines, and basic library statistics.

The project demonstrates important Object-Oriented Programming concepts and Java features covered in Unit I and Unit II.

---

## Features

- View all books available in the REVA University Library
- Search books by title or author
- Register REVA University students
- View registered students
- Borrow books
- Return books
- Calculate library fines
- Add new books
- Display library statistics
- Demonstrate Java OOP concepts

---

## Technologies Used

- Java
- Java OOP
- Java Collections
- Scanner
- Git and GitHub
- VSCodium

---

## Project Structure

```text
LibraryManagementSystem
│
├── src
│   ├── model
│   │   ├── Person.java
│   │   ├── Student.java
│   │   ├── Librarian.java
│   │   ├── Book.java
│   │   ├── BookCategory.java
│   │   └── Borrowable.java
│   │
│   ├── repository
│   │   └── LibraryRepository.java
│   │
│   ├── service
│   │   ├── FineCalculator.java
│   │   └── LibraryService.java
│   │
│   └── main
│       └── LibraryApp.java
│
├── README.md
└── .gitignore