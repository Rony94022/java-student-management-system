package com.kodnest.SMS.StudentManagement;
import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = null;

        try {
            // Loading the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/practice_db",
                "root",
                "******"
            );

            System.out.println("Connection is established");

            int choice;

            do {
                System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("\nEnter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // ADD STUDENT
                        PreparedStatement pstmt1 = null;

                        try {
                            String sql1 = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)";

                            pstmt1 = conn.prepareStatement(sql1);

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();

                            System.out.print("Enter Course: ");
                            String course = sc.nextLine();

                            System.out.print("Enter Marks: ");
                            int marks = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter City: ");
                            String city = sc.nextLine();

                            pstmt1.setInt(1, id);
                            pstmt1.setString(2, name);
                            pstmt1.setString(3, email);
                            pstmt1.setString(4, course);
                            pstmt1.setInt(5, marks);
                            pstmt1.setString(6, city);

                            int rows = pstmt1.executeUpdate();

                            if (rows == 1) {
                                System.out.println("Student Added Successfully");
                            }

                        } finally {
                            if (pstmt1 != null) pstmt1.close();
                        }

                        break;

                    case 2:
                        // DISPLAY ALL STUDENTS
                        PreparedStatement pstmt2 = null;
                        ResultSet rs = null;

                        try {
                            String sql2 = "SELECT * FROM students";

                            pstmt2 = conn.prepareStatement(sql2);
                            rs = pstmt2.executeQuery();

                            System.out.println("\n======================= STUDENT DETAILS =======================");

                            // Table Header
                            System.out.printf("%-10s %-20s %-25s %-12s %-8s %-15s%n",
                                    "ID", "NAME", "EMAIL", "COURSE", "MARKS", "CITY");

                            System.out.println("-----------------------------------------------------------------------------------------------");

                            boolean found = false;

                            while (rs.next()) {

                                found = true;

                                System.out.printf("%-10d %-20s %-25s %-12s %-8d %-15s%n",
                                        rs.getInt("student_id"),
                                        rs.getString("student_name"),
                                        rs.getString("email"),
                                        rs.getString("course"),
                                        rs.getInt("marks"),
                                        rs.getString("city"));
                            }

                            if (!found) {
                                System.out.println("No Student Records Found!");
                            }

                            System.out.println("-----------------------------------------------------------------------------------------------");

                        } finally {
                            if (rs != null) rs.close();
                            if (pstmt2 != null) pstmt2.close();
                        }

                        break;

                    case 3:
                        // UPDATE STUDENT MARKS
                        PreparedStatement pstmt3 = null;

                        try {
                            String sql3 = "UPDATE students SET marks = ? WHERE student_id = ?";

                            pstmt3 = conn.prepareStatement(sql3);

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();

                            System.out.print("Enter New Marks: ");
                            int marks = sc.nextInt();

                            pstmt3.setInt(1, marks);
                            pstmt3.setInt(2, id);

                            int rows = pstmt3.executeUpdate();

                            if (rows == 1) {
                                System.out.println("Marks Updated Successfully");
                            } else {
                                System.out.println("Invalid Student ID");
                            }

                        } finally {
                            if (pstmt3 != null) pstmt3.close();
                        }

                        break;

                    case 4:
                        // DELETE STUDENT
                        PreparedStatement pstmt4 = null;

                        try {
                            String sql4 = "DELETE FROM students WHERE student_id = ?";

                            pstmt4 = conn.prepareStatement(sql4);

                            System.out.print("Enter Student ID to Delete: ");
                            int id = sc.nextInt();

                            pstmt4.setInt(1, id);

                            int rows = pstmt4.executeUpdate();

                            if (rows == 1) {
                                System.out.println("Student Deleted Successfully");
                            } else {
                                System.out.println("Invalid Student ID");
                            }

                        } finally {
                            if (pstmt4 != null) pstmt4.close();
                        }

                        break;

                    case 5:
                        System.out.println("Exiting Student Management System...");
                        break;

                    default:
                        System.out.println("Invalid Choice! Try Again.");
                }

            } while (choice != 5);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (sc != null) sc.close();
                if (conn != null) conn.close();

                System.out.println("Connection Closed");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
