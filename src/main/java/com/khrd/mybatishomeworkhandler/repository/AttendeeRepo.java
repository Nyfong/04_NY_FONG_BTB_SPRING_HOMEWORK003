package com.khrd.mybatishomeworkhandler.repository;


import com.khrd.mybatishomeworkhandler.model.dto.request.AttendeeRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepo {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email"),
    })
    @Select("""
            select * from attendees  offset #{size} *(#{page}-1)  limit #{size};
            """)
    List<Attendee> getAllAttendee(Integer page, Integer size);

    // -- get attendee by Id
    @ResultMap("attendeeMapper")
    @Select(" select  * from attendees where attendee_id = #{attendeeId}")
    Attendee getAttendeeById(Integer attendeeId);



    //-- create attendee

    @Select("insert into attendees values (default, #{attendeeName}, #{email}) ")
    @ResultMap("attendeeMapper")
    Attendee createAttendee(AttendeeRequest attendeeRequest);


    //-- edit attendee
    @Select("update  attendees set attendee_name = #{attendee.attendeeName}, email = #{attendee.email} where  attendee_id =  #{attendeeId}; ")
    @ResultMap("attendeeMapper")
    List<Attendee> editAttendeeById(Integer attendeeId, @Param("attendee") AttendeeRequest attendeeRequest);

    //-- delete attendee by id
    @Select("delete from attendees where  attendee_id =  #{attendeeId}; ")
    @ResultMap("attendeeMapper")
    Integer deleteAttendeeById(Integer attendeeId);


    //addition method
    // addition
    @Select("select COUNT(*) from  attendees where  attendee_id = #{attendeeId};")
    Integer countAttendeeService(Integer attendeeId);


    // find latest method
    @Select("SELECT MAX(attendee_id) FROM attendees;")
    Integer findLatestAttendeeId();


}
