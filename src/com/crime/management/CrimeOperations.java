package com.crime.management;

import java.sql.*;

public class CrimeOperations {
    
    public void addCrime(String crimeType, String description, String date, String location) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Crimes (crime_type, description, date, location) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, crimeType);
            pstmt.setString(2, description);
            pstmt.setString(3, date);
            pstmt.setString(4, location);
            pstmt.executeUpdate();
            System.out.println("Crime added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewCrimes() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Crimes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            	System.out.println("ID: " + rs.getInt("crime_id") + "\n" +
                        "Type: " + rs.getString("crime_type") + "\n" +
                        "Description: " + rs.getString("description") + "\n" +
                        "Date: " + rs.getDate("date") + "\n" +
                        "Location: " + rs.getString("location") + "\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}