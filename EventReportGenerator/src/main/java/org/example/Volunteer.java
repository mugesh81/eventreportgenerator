package org.example;

public class Volunteer {
    private int volunteerId;
    private String volunteerName;
    private String email;

    // Constructor
    public Volunteer(int volunteerId, String volunteerName, String email) {
        this.volunteerId = volunteerId;
        this.volunteerName = volunteerName;
        this.email = email;
    }

    // Getters and Setters
    public int getVolunteerId() {
        return volunteerId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public String getEmail() {
        return email;
    }
}

