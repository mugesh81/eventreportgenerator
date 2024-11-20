package org.example;

public class Feedback {
    private int feedbackId;
    private int eventId;
    private int volunteerId;
    private String feedbackText;
    private int rating;

    // Constructor
    public Feedback(int feedbackId, int eventId, int volunteerId, String feedbackText, int rating) {
        this.feedbackId = feedbackId;
        this.eventId = eventId;
        this.volunteerId = volunteerId;
        this.feedbackText = feedbackText;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public int getRating() {
        return rating;
    }
}
