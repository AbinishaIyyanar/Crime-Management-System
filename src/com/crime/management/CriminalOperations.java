package com.crime.management;

import java.sql.*;
public class CriminalOperations {

    public void addCriminal(String name, int age, String gender, int crimeId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Criminals (name, age, gender, crime_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, crimeId);
            pstmt.executeUpdate();
            System.out.println("Criminal added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewCriminals() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Criminals";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            	System.out.println("ID: " + rs.getInt("criminal_id") + "\n" +
                        "Name: " + rs.getString("name") + "\n" +
                        "Age: " + rs.getInt("age") + "\n" +
                        "Gender: " + rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}