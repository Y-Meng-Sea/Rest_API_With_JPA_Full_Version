package com.example.relationshipjpa.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorResponse {
    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;
    private LocalDateTime timestamp;
}
