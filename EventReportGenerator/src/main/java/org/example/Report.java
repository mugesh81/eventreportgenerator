package org.example;

import java.util.List;

public abstract class Report implements Reportable {
    protected int eventId;
    protected List<Attendance> attendanceData;
    protected List<Feedback> feedbackData;
    protected List<Volunteer> volunteerData;

    public Report(int eventId, List<Attendance> attendanceData, List<Feedback> feedbackData, List<Volunteer> volunteerData) {
        this.eventId = eventId;
        this.attendanceData = attendanceData;
        this.feedbackData = feedbackData;
        this.volunteerData = volunteerData;
    }

    public abstract void generateReport();
}
