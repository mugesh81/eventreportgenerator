package org.example;

import java.util.List;

public class VolunteerReport extends Report {
    public VolunteerReport(int eventId, List<Attendance> attendanceData, List<Feedback> feedbackData, List<Volunteer> volunteerData) {
        super(eventId, attendanceData, feedbackData, volunteerData);
    }

    @Override
    public void generateAttendanceReport() {

    }

    @Override
    public void generateFeedbackReport() {

    }

    @Override
    public void generateVolunteerReport() {
        // Generate volunteer report logic
        System.out.println("Volunteer Report for Event ID: " + eventId);
        for (Volunteer volunteer : volunteerData) {
            System.out.println("Volunteer ID: " + volunteer.getVolunteerId() + ", Name: " + volunteer.getVolunteerName());
        }
    }

    @Override
    public void generateReport() {
        generateVolunteerReport();
    }
}
