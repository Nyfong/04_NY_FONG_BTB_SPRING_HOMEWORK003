package com.khrd.mybatishomeworkhandler.model.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttendeeRequest {
    private String attendeeName;
    private String email;

}
