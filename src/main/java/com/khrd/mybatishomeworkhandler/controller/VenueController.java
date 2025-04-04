package com.khrd.mybatishomeworkhandler.controller;


import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
import com.khrd.mybatishomeworkhandler.model.dto.respone.ApiResponse;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import com.khrd.mybatishomeworkhandler.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")

public class VenueController {
    //Di
    private VenueService venueService;
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    //get all courses
    @Operation(summary = "Get All venues")
    @GetMapping("/")
    public ResponseEntity<?> getAllVenue(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        List<Venue> getAllVenue = venueService.getAllVenueService(page,size);
        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder().timestamp(LocalDateTime.now()).message("retrive all venue").status(HttpStatus.OK).payload(getAllVenue).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //get by id
    @Operation(summary = "Get  venues By Id")
    @GetMapping("/{venue-id}")
    public ResponseEntity<?> getVenuesById(@PathVariable("venue-id") Integer venueId) {

        Venue venueById = venueService.getvenueById(venueId);
        ApiResponse<?> response = ApiResponse.<Venue>builder().timestamp(LocalDateTime.now()).message("retrive  venue by Id").status(HttpStatus.OK).payload(venueById).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //post
    @Operation(summary = "Create  Venues ")
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> createVenue(@RequestBody VenueRequest venueRequest) {
        Venue createVenue = venueService.createVenue(venueRequest);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder().timestamp(LocalDateTime.now()).message("sucesfully create venue ").payload(createVenue).status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Put
    @Operation(summary = "Edit  Venues By Id")
    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<?>> editVenueById(@PathVariable("venue-id")Integer venueId, @RequestBody VenueRequest venueRequest ) {
        Venue editVenueById = venueService.editVenueById(venueId, venueRequest);
        ApiResponse<?> response = ApiResponse.<Venue>builder().timestamp(LocalDateTime.now()).message("sucesfully edit venue ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

  // delete by Id
    @Operation(summary = "Delete  Venues By Id")
    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Integer>> deleteVenueById(@PathVariable("venue-id")Integer venueId) {
        Integer deleteVenueById = venueService.deleteVenueById(venueId);
        ApiResponse<Integer> response = ApiResponse.<Integer>builder().timestamp(LocalDateTime.now()).message("sucesfully delete venue ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

}
