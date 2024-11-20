package org.example;

public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;

    // Constructor
    public Event(int eventId, String eventName, String eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }
}
