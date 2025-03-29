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
        return venueRepo.getAllVenue( page,  size);
    }

    @Override
    public Venue getvenueById(Integer venueId) {
        if(venueRepo.countCourseService(venueId)>0) {
            return venueRepo.getVenueById( venueId);
        }
        throw new NotFoundExceptionHandler("venue with id : "+venueId+" Not Found");
    }

    @Override
    public Venue createVenue(VenueRequest venueRequest) {
        return venueRepo.createVenue(venueRequest);
    }

    @Override
    public List<Venue> editVenueById(Integer venueId, VenueRequest venueRequest) {
        if(venueRepo.countCourseService(venueId)>0) {
            return venueRepo.editVenueById(venueId, venueRequest);
        }
        throw new NotFoundExceptionHandler("venue with id : "+venueId+" Not Found");
    }

    @Override
    public Integer deleteVenueById(Integer venueId) {

        if(venueRepo.countCourseService(venueId)>0) {
            return venueRepo.deleteVenueById(venueId);
        }

        throw new NotFoundExceptionHandler("venue with id : "+venueId+" Not Found");
    }
}
