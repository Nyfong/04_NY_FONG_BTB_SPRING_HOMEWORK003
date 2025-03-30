package com.khrd.mybatishomeworkhandler.model.dto.respone;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiEventRespone <T>{

    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime time;

}
