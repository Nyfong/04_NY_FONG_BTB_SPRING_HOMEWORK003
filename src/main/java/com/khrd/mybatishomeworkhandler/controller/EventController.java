package com.khrd.mybatishomeworkhandler.controller;


import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiEventRespone;
import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiResponse;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Event;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import com.khrd.mybatishomeworkhandler.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    // Di
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //Get all
    @Operation(summary = "Get All Events")
    @GetMapping("/")
    public ResponseEntity<?> getAllEvent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        List<Event> getAllEvent = eventService.getAllEventService(page,size);
        ApiEventRespone<List<Event>> response = ApiEventRespone.<List<Event>>builder().message("retrive all event ").payload(getAllEvent).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //get by id
    @Operation(summary = "Get  Events By Id")
    @GetMapping("/{event-id}")
    public ResponseEntity<?> getEventById(@PathVariable("event-id") Integer eventId) {

        Event eventById = eventService.getEventById(eventId);
        ApiEventRespone<Event> response = ApiEventRespone.<Event>builder().message("retrive event by id").payload(eventById).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete by id
    @Operation(summary = "Delete  Events By Id")
    @DeleteMapping("/{event-id}")
    public ResponseEntity<?> deleteEventById(@PathVariable("event-id") Integer eventId) {

        Event deleteEventById = eventService.deleteEventById(eventId);
        ApiEventRespone<Event> response = ApiEventRespone.<Event>builder().message("delete event by id").payload(deleteEventById).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
