package com.crime.management;

import java.sql.*;
public class CaseAssignmentOperations {

    public void assignCase(int crimeId, int officerId, String status, String startDate, String endDate) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO CaseAssignments (crime_id, officer_id, status, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, crimeId);
            pstmt.setInt(2, officerId);
            pstmt.setString(3, status);
            pstmt.setString(4, startDate);
            pstmt.setString(5, endDate);
            pstmt.executeUpdate();
            System.out.println("Case assigned successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAssignments() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM CaseAssignments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	System.out.println("Case ID: " + rs.getInt("case_id") + "\n" + 
                        "Crime ID: " + rs.getInt("crime_id") + "\n" + 
                        "Officer ID: " + rs.getInt("officer_id") + "\n" + 
                        "Status: " + rs.getString("status") + "\n" + 
                        "Start Date: " + rs.getDate("start_date") + "\n" + 
                        "End Date: " + rs.getDate("end_date"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}