package com.khrd.mybatishomeworkhandler.controller;


import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiEventRespone;
import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiResponse;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Event;
import com.khrd.mybatishomeworkhandler.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        ApiEventRespone<List<Event>> response = ApiEventRespone.<List<Event>>builder().message("").payload(getAllEvent).status(HttpStatus.OK).time(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
