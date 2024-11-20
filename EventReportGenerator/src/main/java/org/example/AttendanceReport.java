package org.example;

import java.util.List;

public class AttendanceReport extends Report {
    public AttendanceReport(int eventId, List<Attendance> attendanceData, List<Feedback> feedbackData, List<Volunteer> volunteerData) {
        super(eventId, attendanceData, feedbackData, volunteerData);
    }

    @Override
    public void generateAttendanceReport() {
        // Generate attendance report logic
        System.out.println("Attendance Report for Event ID: " + eventId);
        for (Attendance attendance : attendanceData) {
            System.out.println("Volunteer ID: " + attendance.getVolunteerId() + ", Attended: " + attendance.isAttended());
        }
    }

    @Override
    public void generateFeedbackReport() {

    }

    @Override
    public void generateVolunteerReport() {

    }

    @Override
    public void generateReport() {
        generateAttendanceReport();
    }
}
