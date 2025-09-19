package com.example.relationshipjpa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_tb")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;
}
