package com.khrd.mybatishomeworkhandler.service.imp;

import com.khrd.mybatishomeworkhandler.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import com.khrd.mybatishomeworkhandler.repository.VenueRepo;
import com.khrd.mybatishomeworkhandler.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VenueServiceImp implements VenueService {
    private final VenueRepo venueRepo;

    @Override
    public List<Venue> getAllVenueService(Integer page, Integer size) {

        if (  size <=0 || page <= 0) {
            //System.out.println("a");
            throw new NotFoundExceptionHandler("must be greater than 0 ");
        }

        else if (venueRepo.findLatestVenueId()<size) {
            System.out.println(size);
            throw new NotFoundExceptionHandler("Invalid size:) ");
        }

        return venueRepo.getAllVenue(page, size);
    }

    @Override
    public Venue getvenueById(Integer venueId) {
        if (venueRepo.countVenueService(venueId) > 0) {
            return venueRepo.getVenueById(venueId);
        }
        throw new NotFoundExceptionHandler("venue with id : " + venueId + " Not Found");
    }

    @Override
    public Venue createVenue(VenueRequest venueRequest) {

        if (venueRequest == null) {
            throw new NotFoundExceptionHandler("Venue request cannot be null");
        }
        if (venueRequest.getVenueName() == null || venueRequest.getVenueName().trim().isEmpty()) {
            throw new NotFoundExceptionHandler("Venue name cannot be empty");
        }
        if (venueRequest.getLocation() == null || venueRequest.getLocation().trim().isEmpty()) {
            throw new NotFoundExceptionHandler("Location cannot be empty");
        }
        return venueRepo.createVenue(venueRequest);
    }

    @Override
    public Venue editVenueById(Integer venueId, VenueRequest venueRequest) {
        if (venueRepo.countVenueService(venueId) > 0) {
            return venueRepo.editVenueById(venueId, venueRequest);
        }
        throw new NotFoundExceptionHandler("venue with id : " + venueId + " Not Found");
    }

    @Override
    public Integer deleteVenueById(Integer venueId) {

        if (venueRepo.countVenueService(venueId) > 0) {
            return venueRepo.deleteVenueById(venueId);
        }

        throw new NotFoundExceptionHandler("venue with id : " + venueId + " Not Found");
    }
}
