package com.khrd.mybatishomeworkhandler.model.dto.request;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class EventRequestV1 {
    private final String eventName;
    private Integer venueId;
    private String date;
    private List<Integer> attendeesId;

}
