package com.khrd.mybatishomeworkhandler.service.imp;

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
}
