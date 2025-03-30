package com.khrd.mybatishomeworkhandler.repository;


import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequest;
import com.khrd.mybatishomeworkhandler.model.dto.request.EventRequestV1;
import com.khrd.mybatishomeworkhandler.model.entity.Attendee;
import com.khrd.mybatishomeworkhandler.model.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public  interface  EventRepo {
    @Select("SELECT * FROM events ORDER BY event_id OFFSET #{size} * (#{page} - 1) LIMIT #{size}")
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "date", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "com.khrd.mybatishomeworkhandler.repository.VenueRepo.getVenueById")),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "com.khrd.mybatishomeworkhandler.repository.EventRepo.getAttendeesByEventId"))
    })
    List<Event> getAllEventService(@Param("page") Integer page, @Param("size") Integer size);

    @Select("""
        SELECT a.attendee_id, a.attendee_name, a.email
        FROM attendees a
        JOIN event_attendee ea ON a.attendee_id = ea.attendee_id
        WHERE ea.event_id = #{eventId}
        """)
    @Results({
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    List<Attendee> getAttendeesByEventId(@Param("eventId") int eventId);

    //--
    @Select(" select * from events where event_id = #{eventId}")
    @ResultMap("eventMapper")
    Event getEventServiceById(Integer eventId);
    // --

    @Select(" delete  from events where event_id =  #{eventId};")
    @ResultMap("eventMapper")
    Event deleteEventById(Integer eventId);
    //-- create
    @Select("""
        INSERT INTO events(event_name, venue_id, event_date)
        VALUES(#{eventName}, #{venueId}, #{date})
        RETURNING  event_id;
        """)
    @ResultMap("eventMapper")
    Event createEvent(EventRequestV1 eventRequestV1);




//    // addition
    @Select("SELECT COUNT(*) FROM events  where  event_id = #{eventId};")
    Integer findTheEvent(Integer eventId);

    //-- edit
    @Select("""
        update  events set event_name = #{event.eventName}, venue_id = #{event.venueId}, event_date = #{event.date} where event_id = #{eventId};
        """)
    @ResultMap("eventMapper")
    Event EditEventById(Integer eventId, @Param("event") EventRequestV1 eventRequestV1);
}
