package com.example.relationshipjpa.model.entity;

import com.example.relationshipjpa.model.entity.constant.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "passport_tb")
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private String country;
    private String expirationDate;
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}
