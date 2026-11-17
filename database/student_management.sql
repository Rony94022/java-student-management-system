-- Student Management System Database

CREATE DATABASE IF NOT EXISTS practice_db;

USE practice_db;

CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50),
    marks INT,
    city VARCHAR(50)
);

-- Sample Data

INSERT INTO students
(student_id, student_name, email, course, marks, city)
VALUES
(1, 'Rahul', 'rahul@gmail.com', 'Java', 85, 'Bangalore'),
(2, 'Amit', 'amit@gmail.com', 'Python', 90, 'Delhi'),
(3, 'Priya', 'priya@gmail.com', 'SQL', 78, 'Mumbai'),
(4, 'Sneha', 'sneha@gmail.com', 'Java', 92, 'Bhubaneswar'),
(5, 'Rohit', 'rohit@gmail.com', 'Python', 67, 'Kolkata');