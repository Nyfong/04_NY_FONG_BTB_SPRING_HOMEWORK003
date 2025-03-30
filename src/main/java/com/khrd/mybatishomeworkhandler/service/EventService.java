package com.khrd.mybatishomeworkhandler.service;

import com.khrd.mybatishomeworkhandler.model.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEventService(Integer page, Integer size);

    Event getEventById(Integer eventId);

    Event deleteEventById(Integer eventId);
}
