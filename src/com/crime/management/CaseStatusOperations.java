package com.crime.management;

import java.sql.*;

public class CaseStatusOperations {

    public void addCaseStatus(int caseId, String status, String updateDate) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO CaseStatus (case_id, status, update_date) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, caseId);
            pstmt.setString(2, status);
            pstmt.setString(3, updateDate);
            pstmt.executeUpdate();
            System.out.println("Case status added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewCaseStatus(int caseId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM CaseStatus WHERE case_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, caseId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	System.out.println("Status ID: " + rs.getInt("status_id") + "\n" + 
                        "Status: " + rs.getString("status") + "\n" + 
                        "Update Date: " + rs.getDate("update_date"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}