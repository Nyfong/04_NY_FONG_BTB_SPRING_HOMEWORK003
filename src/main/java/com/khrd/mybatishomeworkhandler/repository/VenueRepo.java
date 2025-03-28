package com.khrd.mybatishomeworkhandler.repository;

import com.khrd.mybatishomeworkhandler.model.dto.request.VenueRequest;
import com.khrd.mybatishomeworkhandler.model.entity.Venue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepo {

    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "location", column = "location"),
    })
    @Select("select * from venues  offset #{size} *(#{page}-1) \n" +
            "                  limit #{size};            ;")
    List<Venue> getAllVenue(Integer page, Integer size);

    //--
    @Select("select * from venues where venue_id= #{venueId};")
    @ResultMap("venueMapper")
    Venue getVenueById(Integer venueId);


    // --
    @Select("INSERT INTO venues (venue_name, location) VALUES ()")
    @ResultMap("venueMapper")
    Venue createVenue(VenueRequest venueRequest);


    // addition
    @Select("select COUNT(*) from  venues where  venue_id = #{venueId};")
    Integer countCourseService(Integer venueId);


}
