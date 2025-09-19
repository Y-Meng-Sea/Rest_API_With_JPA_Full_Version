package com.example.relationshipjpa.service;

import com.example.relationshipjpa.model.dto.request.PersonRequest;
import com.example.relationshipjpa.model.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Person> getAllPerson();

    Person insertNewUser(PersonRequest personRequest);
}
