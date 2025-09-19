package com.example.relationshipjpa.model.dto.request;

import com.example.relationshipjpa.model.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PersonRequest {
    private String firstName;
    private String lastName;
    private String email;
    private PassportRequest passportRequest;
}
