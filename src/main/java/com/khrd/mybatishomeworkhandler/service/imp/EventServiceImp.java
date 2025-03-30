package com.khrd.mybatishomeworkhandler.service.imp;

import com.khrd.mybatishomeworkhandler.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequest;
import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequestV1;
import com.khrd.mybatishomeworkhandler.model.entity.Event;
import com.khrd.mybatishomeworkhandler.repository.EventRepo;
import com.khrd.mybatishomeworkhandler.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService {

    //Di
    private final EventRepo eventRepo;
    public EventServiceImp(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<Event> getAllEventService(Integer page, Integer size) {
        return  eventRepo.getAllEventService(page, size);
    }

    @Override
    public Event getEventById(Integer eventId) {
        if (eventId != null &&  eventRepo.findTheEvent(eventId) > 0) {
            return eventRepo.getEventServiceById(eventId);
        }
        if(eventId > 0){
            throw new NotFoundExceptionHandler("event with id must greater than 0");
        }
        throw new NotFoundExceptionHandler("event with id : " + eventId + " Not Found");
    }

    @Override
    public Event deleteEventById(Integer eventId) {
        if(eventRepo.findTheEvent(eventId) > 0){
            return eventRepo.deleteEventById(eventId);
        }
        if(eventId > 0){
            throw new NotFoundExceptionHandler("event with id must greater than 0");
        }
        throw new NotFoundExceptionHandler("event with id : " + eventId + " Not Found");
    }

    @Override
    public Event createEvent(EventRequestV1 eventRequestV1) {
        return eventRepo.createEvent(eventRequestV1);
    }

    @Override
    public Event editEventById(Integer eventId, EventRequestV1 eventRequestV1) {
        return null;
    }


}
