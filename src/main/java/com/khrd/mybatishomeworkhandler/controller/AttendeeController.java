package com.khrd.mybatishomeworkhandler.controller;

import com.khrd.mybatishomeworkhandler.model.dto.request.AttendeeRequest;
import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiResponse;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import com.khrd.mybatishomeworkhandler.service.AttendeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    //Di
    private  final AttendeeService attendeeService;
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }
    //Get all
    @Operation(summary = "Get All Attendee")
    @GetMapping("/")
    public ResponseEntity<?> getAllAttendee(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {

        List<Attendee> getAllAttendee = attendeeService.getAllAttendeeService(page,size);
        ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder().timestamp(LocalDateTime.now()).message("retrive all attendee").status(HttpStatus.OK).payload(getAllAttendee).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //get by id
    @Operation(summary = "Get  Attendee By Id")
    @GetMapping("/{attendee-id}")
    public ResponseEntity<?> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {

        Attendee attendeeById = attendeeService.getAttendeeById(attendeeId);
        ApiResponse<?> response = ApiResponse.<Attendee>builder().timestamp(LocalDateTime.now()).message("retrive  venue by Id").status(HttpStatus.OK).payload(attendeeById).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //post
    @Operation(summary = "Create  Attendee ")
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> createVenue(@RequestBody AttendeeRequest attendeeRequest) {
        Attendee createAttendee = attendeeService.createAttendee(attendeeRequest);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder().timestamp(LocalDateTime.now()).message("sucesfully create venue ").payload(createAttendee).status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Put
    @Operation(summary = "Edit  Attendee By Id")
    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<List<Attendee>>> editVenueById(@PathVariable("attendee-id")Integer attendeeId, @RequestBody AttendeeRequest attendeeRequest) {
        List<Attendee> editAttendeeById = attendeeService.editAttendeeById(attendeeId, attendeeRequest);
        ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder().timestamp(LocalDateTime.now()).message("sucesfully edit venue ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete by Id
    @Operation(summary = "Delete  Attendee By Id")
    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Integer>> deleteVenueById(@PathVariable("attendee-id")Integer attendeeId) {
        Integer deleteAttendeeById = attendeeService.deleteAttendeeById(attendeeId);
        ApiResponse<Integer> response = ApiResponse.<Integer>builder().timestamp(LocalDateTime.now()).message("sucesfully delete venue ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

}
