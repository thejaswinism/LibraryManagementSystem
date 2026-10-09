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
OUTPUT:
PS C:\Users\Thejaswini S M\OneDrive\Documents\LibraryManagementSystem> javac -d out src/model/*.java src/repository/*.java src/service/*.java src/main/*.java
PS C:\Users\Thejaswini S M\OneDrive\Documents\LibraryManagementSystem> java -cp out main.LibraryApp
====================================================
       REVA UNIVERSITY LIBRARY MANAGEMENT SYSTEM
====================================================

-------------------- MAIN MENU --------------------
1. View All Books
2. Search Book
3. Register REVA Student
4. View Registered Students
5. Borrow Book
6. Return Book
7. Calculate Fine
8. Add New Book
9. Library Statistics
10. OOP Demonstration
0. Exit
----------------------------------------------------
Enter your choice: 1

REVA UNIVERSITY LIBRARY - BOOK COLLECTION
--------------------------------------------------------------------------
ID       Title                               Author                    Category             Status    
--------------------------------------------------------------------------
B101     Java Programming                    Herbert Schildt           PROGRAMMING          Available 
B102     Data Structures and Algorithms      Thomas Cormen             COMPUTER_SCIENCE     Available 
B103     Bioinformatics Algorithms           Phillip Compeau           BIOINFORMATICS       Available 
B104     Statistical Methods                 George Snedecor           STATISTICS           Available 
B105     Database Management Systems         Raghu Ramakrishnan        DATABASES            Available 
B106     Python for Data Science             Wes McKinney              DATA_SCIENCE         Available 

Enter your choice: 2
Enter book title or author: java
B101     Java Programming                    Herbert Schildt           PROGRAMMING          Available 

Enter your choice: 3

--- REVA STUDENT REGISTRATION ---
Enter student name: Varsha
Enter SRN: R24SA050
Enter course: BSc MCG
Enter semester:  
5
Student registered successfully!

----------------------------------------------------
Enter your choice: 4

--------- REGISTERED REVA STUDENTS ---------
Name: Thejaswini S M, ID: R24SA043, Course: B.Sc. BSTCs, Semester: 5, Borrowed Books: 0
Name: Varsha, ID: R24SA050, Course: BSc MCG, Semester: 5, Borrowed Books: 0

----------------------------------------------------
Enter your choice: 5
Enter Book ID: B101
Enter Student SRN: R24SA043
Book borrowed successfully!

----------------------------------------------------
Enter your choice: 6
Enter Book ID: B101
Enter Student SRN: R25SA050
Unable to return book.

----------------------------------------------------
Enter your choice: 7
Enter number of days late: 3
Library Fine: Rs. 6.00

----------------------------------------------------
Enter your choice: 8

--- ADD NEW BOOK ---
Enter Book ID: Q101
Enter book title: ARDBMS
Enter author: XYZ

Select Book Category:
1. COMPUTER_SCIENCE
2. BIOINFORMATICS
3. STATISTICS
4. MATHEMATICS
5. BIOLOGY
6. DATA_SCIENCE
7. DATABASES
8. PROGRAMMING
Enter category number: 1
Book added successfully to REVA University Library!

----------------------------------------------------
Enter your choice: 9

========== REVA LIBRARY STATISTICS ==========
Total Books: 7
Total Registered Students: 1
=============================================

Enter your choice: 10

========== OOP DEMONSTRATION ==========
Role: REVA University Student
Role: REVA University Librarian
Interface reference successfully used.
Dynamic binding successfully demonstrated.
========================================

Enter your choice: 0

Thank you for using
REVA University Library Management System!

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
