package com.crime.management;

import java.sql.*;
public class ReportsOperations {

    // Report for all unresolved cases
    public void viewUnresolvedCases() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM CaseAssignments WHERE status <> 'Resolved'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	System.out.println("Case ID: " + rs.getInt("case_id") + "\n" +
                        "Crime ID: " + rs.getInt("crime_id") + "\n" +
                        "Officer ID: " + rs.getInt("officer_id") + "\n" +
                        "Status: " + rs.getString("status"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Report for the number of cases per crime type
    public void viewCasesPerCrimeType() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT crime_type, COUNT(*) as case_count FROM Crimes GROUP BY crime_type";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	System.out.println("Crime Type: " + rs.getString("crime_type") + "\n" +
                        "Case Count: " + rs.getInt("case_count"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}