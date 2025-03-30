package com.khrd.mybatishomeworkhandler.service;


import com.khrd.mybatishomeworkhandler.model.dto.request.AttendeeRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendeeService(Integer page, Integer size);

    Attendee getAttendeeById(Integer attendeeId);

    Attendee createAttendee(AttendeeRequest attendeeRequest);

    List<Attendee> editAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest);

    Integer deleteAttendeeById(Integer attendeeId);
}
