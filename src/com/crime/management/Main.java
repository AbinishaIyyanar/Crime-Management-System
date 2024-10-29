package com.crime.management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrimeOperations crimeOps = new CrimeOperations();
        CriminalOperations criminalOps = new CriminalOperations();
        OfficerOperations officerOps = new OfficerOperations();
        CaseAssignmentOperations caseAssignmentOps = new CaseAssignmentOperations();
        CaseStatusOperations caseStatusOps = new CaseStatusOperations();
        ReportsOperations reportsOps = new ReportsOperations();
        AdminOperations adminOps = new AdminOperations();

        // Sample menu for user interaction
        while (true) {
            System.out.println("Welcome to the Crime Management System");
            System.out.println("1. Add Crime");
            System.out.println("2. View Crimes");
            System.out.println("3. Add Criminal");
            System.out.println("4. View Criminals");
            System.out.println("5. Add Officer");
            System.out.println("6. View Officers");
            System.out.println("7. Assign Case");
            System.out.println("8. View Assignments");
            System.out.println("9. Add Case Status");
            System.out.println("10. View Case Status");
            System.out.println("11. View Unresolved Cases");
            System.out.println("12. View Cases Per Crime Type");
            System.out.println("13. Add User");
            System.out.println("14. View Users");
            System.out.println("15. Delete User");
            System.out.println("16. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1: // Add Crime
                    System.out.println("Enter crime type: ");
                    String crimeType = scanner.nextLine();
                    System.out.println("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.println("Enter location: ");
                    String location = scanner.nextLine();
                    crimeOps.addCrime(crimeType, description, date, location);
                    break;

                case 2: // View Crimes
                    crimeOps.viewCrimes();
                    break;

                case 3: // Add Criminal
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter crime ID: ");
                    int crimeId = scanner.nextInt();
                    criminalOps.addCriminal(name, age, gender, crimeId);
                    break;

                case 4: // View Criminals
                    criminalOps.viewCriminals();
                    break;

                case 5: // Add Office
                    System.out.print("Enter officer name: ");
                    String officerName = scanner.nextLine();
                    System.out.print("Enter officer rank: ");
                    String officerRank = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    officerOps.addOfficer(officerName, officerRank, department, contact);
                    break;

                case 6: // View Officers
                    officerOps.viewOfficers();
                    break;

                case 7: // Assign Case
                    System.out.print("Enter crime ID: ");
                    int assignedCrimeId = scanner.nextInt();
                    System.out.print("Enter officer ID: ");
                    int officerId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    caseAssignmentOps.assignCase(assignedCrimeId, officerId, status, startDate, endDate);
                    break;

                case 8: // View Assignments
                    caseAssignmentOps.viewAssignments();
                    break;

                case 9: // Add Case Status
                    System.out.print("Enter case ID: ");
                    int caseId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter status: ");
                    String caseStatus = scanner.nextLine();
                    System.out.print("Enter update date (YYYY-MM-DD): ");
                    String updateDate = scanner.nextLine();
                    caseStatusOps.addCaseStatus(caseId, caseStatus, updateDate);
                    break;

                case 10: // View Case Status
                    System.out.print("Enter case ID: ");
                    int statusCaseId = scanner.nextInt();
                    caseStatusOps.viewCaseStatus(statusCaseId);
                    break;

                case 11: // View Unresolved Cases
                    reportsOps.viewUnresolvedCases();
                    break;

                case 12: // View Cases Per Crime Type
                    reportsOps.viewCasesPerCrimeType();
                    break;

                case 13: // Add User
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    adminOps.addUser(username, password, role);
                    break;

                case 14: // View Users
                    adminOps.viewUsers();
                    break;

                case 15: // Delete User
                    System.out.print("Enter user ID to delete: ");
                    int userId = scanner.nextInt();
                    adminOps.deleteUser(userId);
                    break;

                case 16: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}