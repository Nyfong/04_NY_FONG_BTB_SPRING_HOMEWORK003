package com.khrd.mybatishomeworkhandler.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private Integer venueId;
    private String venueName;
    private String location;
}
