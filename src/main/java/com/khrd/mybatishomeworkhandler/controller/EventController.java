package com.khrd.mybatishomeworkhandler.controller;


import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequest;
import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequestV1;
import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
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
        ApiEventRespone<List<Event>> response = ApiEventRespone.<List<Event>>builder().message("retrive all event successfully").payload(getAllEvent).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //get by id
    @Operation(summary = "Get  Events By Id")
    @GetMapping("/{event-id}")
    public ResponseEntity<?> getEventById(@PathVariable("event-id") Integer eventId) {

        Event eventById = eventService.getEventById(eventId);
        ApiEventRespone<Event> response = ApiEventRespone.<Event>builder().message("retrive event by id successfully").payload(eventById).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete by id
    @Operation(summary = "Delete  Events By Id")
    @DeleteMapping("/{event-id}")
    public ResponseEntity<?> deleteEventById(@PathVariable("event-id") Integer eventId) {

        Event deleteEventById = eventService.deleteEventById(eventId);
        ApiEventRespone<Event> response = ApiEventRespone.<Event>builder().message("delete event by id successfully ").payload(deleteEventById).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //post
    @Operation(summary = "Create  Event ")
    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventRequestV1 eventRequestV1) {
        Event createdEvent = eventService.createEvent(eventRequestV1);
        ApiEventRespone<Event> response = ApiEventRespone.<Event>builder()
                .message("The event has been successfully added.")
                .payload(createdEvent)
                .status(HttpStatus.CREATED) // Use CREATED status code (201)
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Put
    @Operation(summary = "Edit  Event By Id")
    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<?>> editVenueById(@PathVariable("event-id")Integer eventId, @RequestBody  EventRequestV1 eventRequestV1 ) {
        Event editEventById = eventService.editEventById(eventId, eventRequestV1);
        ApiResponse<?> response = ApiResponse.<Event>builder().timestamp(LocalDateTime.now()).message("sucesfully edit Event ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
