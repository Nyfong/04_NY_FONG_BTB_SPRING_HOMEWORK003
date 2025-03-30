package com.khrd.mybatishomeworkhandler.service.imp;

import com.khrd.mybatishomeworkhandler.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomeworkhandler.model.dto.request.AttendeeRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.repository.AttendeeRepo;
import com.khrd.mybatishomeworkhandler.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttendeeServiceImp implements AttendeeService {
    //Di
    private  final AttendeeRepo attendeeRepo;

    @Override
    public List<Attendee> getAllAttendeeService(Integer page, Integer size) {
        if (  size <=0 || page <= 0) {
            System.out.println("a");
            throw new NotFoundExceptionHandler("must be greater than 0 ");
        } else if (attendeeRepo.findLatestAttendeeId()<size) {
            throw new NotFoundExceptionHandler("Invalid size:) ");
        } else return attendeeRepo.getAllAttendee(page, size);
    }

    @Override
    public Attendee getAttendeeById(Integer attendeeId) {
        if(attendeeRepo.countAttendeeService(attendeeId)>0){
            return attendeeRepo.getAttendeeById(attendeeId);
        }
        throw new NotFoundExceptionHandler("Can not get Attendee with id : " + attendeeId + " Not Found");
    }

    @Override
    public Attendee createAttendee(AttendeeRequest attendeeRequest) {

        if (attendeeRequest == null) {
            throw new NotFoundExceptionHandler("Attendee request cannot be null");
        }
        if (attendeeRequest.getAttendeeName() == null || attendeeRequest.getAttendeeName().trim().isEmpty()) {
            throw new NotFoundExceptionHandler("Attendee name cannot be empty");
        }
        if (attendeeRequest.getEmail() == null || !attendeeRequest.getEmail().contains("@")) {
            throw new NotFoundExceptionHandler("Invalid email address");
        }
        return attendeeRepo.createAttendee(attendeeRequest);
    }

    @Override
    public List<Attendee> editAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
        if(attendeeRepo.countAttendeeService(attendeeId)>0){
            return attendeeRepo.editAttendeeById(attendeeId, attendeeRequest);
        }
        throw new NotFoundExceptionHandler("Can not edit Attendee with id : " + attendeeId + " Not Found");
    }

    @Override
    public Integer deleteAttendeeById(Integer attendeeId) {
        if(attendeeRepo.countAttendeeService(attendeeId)>0){
            return attendeeRepo.deleteAttendeeById(attendeeId);
        }
        else if (  attendeeId <=0 ) {
            throw new NotFoundExceptionHandler("must be greater than 0 ");
        }
        throw new NotFoundExceptionHandler("Can not delete Attendee with id : " + attendeeId + " Not Found");
    }
}
