package com.khrd.mybatishomeworkhandler.repository;


import com.khrd.mybatishomeworkhandler.model.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public  interface  EventRepo {

    @Select(" select  * from events;")
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "email", column = "venue_id"),
            @Result(property = "date", column = "date"),

    })
    List<Event> getAllEventService(Integer page, Integer size);

    // addition
    @Select("select COUNT(*) from  venues where  venue_id = #{venueId};")
    Integer countVenueService(Integer venueId);
}
