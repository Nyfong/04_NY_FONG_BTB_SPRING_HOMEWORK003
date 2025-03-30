package com.khrd.mybatishomeworkhandler.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Event {
    private final Integer eventId;
    private final String eventName;
    private final String date;
    private final  Integer venueId;
}
