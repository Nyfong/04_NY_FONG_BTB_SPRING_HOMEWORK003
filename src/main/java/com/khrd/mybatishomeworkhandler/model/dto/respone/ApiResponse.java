package com.khrd.mybatishomeworkhandler.model.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;
    private T payload;
}
