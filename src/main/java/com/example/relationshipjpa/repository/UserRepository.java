package com.example.relationshipjpa.repository;

import com.example.relationshipjpa.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {

}
