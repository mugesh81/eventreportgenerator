package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            // Establish the database connection
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);  // Start transaction

            // Get event data from the user
            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            System.out.print("Enter event name: ");
            String eventName = scanner.nextLine();
            System.out.print("Enter event date (YYYY-MM-DD): ");
            String eventDate = scanner.nextLine();

            // Insert event data into the database
            String insertEventQuery = "INSERT INTO Event (event_id, event_name, event_date) VALUES (?, ?, ?)";
            try (PreparedStatement eventStmt = connection.prepareStatement(insertEventQuery)) {
                eventStmt.setInt(1, eventId);
                eventStmt.setString(2, eventName);
                eventStmt.setDate(3, Date.valueOf(eventDate));
                eventStmt.executeUpdate();
            }

            // Get volunteer data from the user
            List<Volunteer> volunteerList = new ArrayList<>();
            System.out.print("Enter the number of volunteers: ");
            int numVolunteers = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            String insertVolunteerQuery = "INSERT INTO Volunteer (volunteer_id, volunteer_name, volunteer_email) VALUES (?, ?, ?)";
            for (int i = 0; i < numVolunteers; i++) {
                System.out.println("Enter details for volunteer " + (i + 1) + ":");
                System.out.print("Volunteer ID: ");
                int volunteerId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Volunteer name: ");
                String volunteerName = scanner.nextLine();
                System.out.print("Volunteer email: ");
                String email = scanner.nextLine();

                // Insert volunteer data into the database
                try (PreparedStatement volunteerStmt = connection.prepareStatement(insertVolunteerQuery)) {
                    volunteerStmt.setInt(1, volunteerId);
                    volunteerStmt.setString(2, volunteerName);
                    volunteerStmt.setString(3, email);
                    volunteerStmt.executeUpdate();
                }

                volunteerList.add(new Volunteer(volunteerId, volunteerName, email));
            }

            // Get attendance data from the user and store in database
            List<Attendance> attendanceList = new ArrayList<>();
            String insertAttendanceQuery = "INSERT INTO Attendance (event_id, volunteer_id, attended) VALUES (?, ?, ?)";
            for (Volunteer volunteer : volunteerList) {
                System.out.print("Did volunteer " + volunteer.getVolunteerName() + " attend the event? (yes/no): ");
                String attended = scanner.nextLine();
                boolean isAttended = attended.equalsIgnoreCase("yes");

                // Insert attendance data into the database
                try (PreparedStatement attendanceStmt = connection.prepareStatement(insertAttendanceQuery)) {
                    attendanceStmt.setInt(1, eventId);
                    attendanceStmt.setInt(2, volunteer.getVolunteerId());
                    attendanceStmt.setBoolean(3, isAttended);
                    attendanceStmt.executeUpdate();
                }

                attendanceList.add(new Attendance(attendanceList.size() + 1, eventId, volunteer.getVolunteerId(), isAttended));
            }

            // Get feedback data from the user and store in database
            List<Feedback> feedbackList = new ArrayList<>();
            String insertFeedbackQuery = "INSERT INTO Feedback (event_id, volunteer_id, feedback_text, rating) VALUES (?, ?, ?, ?)";
            for (Volunteer volunteer : volunteerList) {
                System.out.print("Enter feedback for volunteer " + volunteer.getVolunteerName() + ": ");
                String feedbackText = scanner.nextLine();
                System.out.print("Enter rating (1-5) for volunteer " + volunteer.getVolunteerName() + ": ");
                int rating = scanner.nextInt();
                scanner.nextLine();  // Consume newline character

                // Insert feedback data into the database
                try (PreparedStatement feedbackStmt = connection.prepareStatement(insertFeedbackQuery)) {
                    feedbackStmt.setInt(1, eventId);
                    feedbackStmt.setInt(2, volunteer.getVolunteerId());
                    feedbackStmt.setString(3, feedbackText);
                    feedbackStmt.setInt(4, rating);
                    feedbackStmt.executeUpdate();
                }

                feedbackList.add(new Feedback(feedbackList.size() + 1, eventId, volunteer.getVolunteerId(), feedbackText, rating));
            }

            // Commit the transaction
            connection.commit();

            // Generate reports based on data (assumes the classes are defined elsewhere)
            Report attendanceReport = new AttendanceReport(eventId, attendanceList, feedbackList, volunteerList);
            attendanceReport.generateReport();

            Report feedbackReport = new FeedbackReport(eventId, attendanceList, feedbackList, volunteerList);
            feedbackReport.generateReport();

            Report volunteerReport = new VolunteerReport(eventId, attendanceList, feedbackList, volunteerList);
            volunteerReport.generateReport();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) connection.rollback();  // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
