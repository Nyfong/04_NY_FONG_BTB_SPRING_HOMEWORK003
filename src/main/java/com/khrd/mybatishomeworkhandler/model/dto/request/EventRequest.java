package com.khrd.mybatishomeworkhandler.model.dto.request;


import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class EventRequest {

    private final String eventName;
    private String date;
     private int venueId;
    private List<Integer> attendees;

}
