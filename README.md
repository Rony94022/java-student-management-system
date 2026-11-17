# Student Management System

## Project Overview
A console-based Student Management System developed using Java, JDBC, MySQL and Maven.

This application allows users to manage student records through a menu-driven interface.

## Technologies Used
- Java 8
- JDBC
- MySQL 8.0
- Maven
- Eclipse IDE

## Features
1. Add Student
2. Display All Students
3. Update Student Marks
4. Delete Student
5. Exit

## Database Structure
**Database:** practice_db

**Table:** students

| Column | Data Type |
|---|---|
| student_id | INT (Primary Key) |
| student_name | VARCHAR(100) |
| email | VARCHAR(100) |
| course | VARCHAR(50) |
| marks | INT |
| city | VARCHAR(50) |

## Project Structure
- `src/main/java` – Java source code
- `database/student_management.sql` – Database creation and sample data
- `pom.xml` – Maven dependencies

## How to Run
1. Clone this repository.
2. Import the project into Eclipse as an Existing Maven Project.
3. Execute `database/student_management.sql` in MySQL Workbench.
4. Configure your MySQL database credentials.
5. Update Maven dependencies.
6. Run `App.java`.

## Author
B.Tech Computer Science and Engineering Graduate