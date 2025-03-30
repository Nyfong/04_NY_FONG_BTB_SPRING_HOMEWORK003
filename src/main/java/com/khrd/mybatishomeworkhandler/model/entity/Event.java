package com.khrd.mybatishomeworkhandler.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Event {
    private final Integer eventId;
    private final String eventName;
    private String date;
    Venue  venue;
    private List<Attendee> attendees;

}
