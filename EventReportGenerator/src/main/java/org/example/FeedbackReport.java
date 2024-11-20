package org.example;

import java.util.List;

public class FeedbackReport extends Report {
    public FeedbackReport(int eventId, List<Attendance> attendanceData, List<Feedback> feedbackData, List<Volunteer> volunteerData) {
        super(eventId, attendanceData, feedbackData, volunteerData);
    }

    @Override
    public void generateAttendanceReport() {

    }

    @Override
    public void generateFeedbackReport() {
        // Generate feedback report logic
        System.out.println("Feedback Report for Event ID: " + eventId);
        for (Feedback feedback : feedbackData) {
            System.out.println("Volunteer ID: " + feedback.getVolunteerId() + ", Rating: " + feedback.getRating() + ", Feedback: " + feedback.getFeedbackText());
        }
    }

    @Override
    public void generateVolunteerReport() {

    }

    @Override
    public void generateReport() {
        generateFeedbackReport();
    }
}
