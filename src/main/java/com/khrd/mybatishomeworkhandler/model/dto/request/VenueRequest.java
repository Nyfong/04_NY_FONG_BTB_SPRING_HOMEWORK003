package com.khrd.mybatishomeworkhandler.model.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VenueRequest {
    private String venueName;
    private String location;
}
