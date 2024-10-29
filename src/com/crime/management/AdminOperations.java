package com.crime.management;

import java.sql.*;

public class AdminOperations {

    // Method to add a new user
    public void addUser(String username, String password, String role) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view all users
    public void viewUsers() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	System.out.println("User ID: " + rs.getInt("user_id") + "\n" +
                        "Username: " + rs.getString("username") + "\n" +
                        "Role: " + rs.getString("role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a user by ID
    public void deleteUser(int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for admin login (authentication)
    public boolean login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // If a result is returned, login is successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}