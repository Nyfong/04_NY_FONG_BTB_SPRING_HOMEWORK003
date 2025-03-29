package com.khrd.mybatishomeworkhandler.service;

import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenueService(Integer page, Integer size);

    Venue getvenueById(Integer venueId);

    Venue createVenue(VenueRequest venueRequest);

    List<Venue> editVenueById(Integer venueId, VenueRequest venueRequest);

    Integer deleteVenueById(Integer venueId);
}
