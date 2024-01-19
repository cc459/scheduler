package com.example.scheduler;

import java.util.Date;

public class Event {
    private String eventName;
    private Date eventDate;

    public Event(String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return this.eventName;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

}
