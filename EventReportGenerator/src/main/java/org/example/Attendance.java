package org.example;

public class Attendance {
    private int attendanceId;
    private int eventId;
    private int volunteerId;
    private boolean attended;

    // Constructor
    public Attendance(int attendanceId, int eventId, int volunteerId, boolean attended) {
        this.attendanceId = attendanceId;
        this.eventId = eventId;
        this.volunteerId = volunteerId;
        this.attended = attended;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public boolean isAttended() {
        return attended;
    }
}

