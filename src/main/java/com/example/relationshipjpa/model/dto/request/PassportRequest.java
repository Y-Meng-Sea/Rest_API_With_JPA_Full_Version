package com.example.relationshipjpa.model.dto.request;

import com.example.relationshipjpa.model.entity.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PassportRequest {
    private String name;
    private String nationality;
    private String country;
    private String expirationDate;
    private Gender gender;
}
