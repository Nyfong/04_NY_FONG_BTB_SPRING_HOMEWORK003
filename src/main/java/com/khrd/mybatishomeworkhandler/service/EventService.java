package com.khrd.mybatishomeworkhandler.service;

import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequest;
import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequestV1;
import com.khrd.mybatishomeworkhandler.model.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEventService(Integer page, Integer size);

    Event getEventById(Integer eventId);

    Event deleteEventById(Integer eventId);

    Event createEvent(EventRequestV1 eventRequestV1);
}
