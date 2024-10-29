package com.crime.management;

import java.sql.*;
public class OfficerOperations {

	public void addOfficer(String name, String rank, String department, String contact) {
	    try (Connection conn = DatabaseConnection.getConnection()) {
	        String query = "INSERT INTO Officers (officer_name, officer_rank, department, contact) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, name); // This should be officer_name
	        pstmt.setString(2, rank); // Use officer_rank instead of ranks
	        pstmt.setString(3, department);
	        pstmt.setString(4, contact);
	        pstmt.executeUpdate();
	        System.out.println("Officer added successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



	public void viewOfficers() {
	    try (Connection conn = DatabaseConnection.getConnection()) {
	        String query = "SELECT * FROM Officers";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	System.out.println("ID: " + rs.getInt("officer_id") + "\n" + 
	                    "Name: " + rs.getString("officer_name") + "\n" + // Use officer_name
	                    "Rank: " + rs.getString("officer_rank") + "\n" + // Use officer_rank
	                    "Department: " + rs.getString("department") + "\n" + 
	                    "Contact: " + rs.getString("contact"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}