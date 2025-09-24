package com.example.relationshipjpa.controller;

import com.example.relationshipjpa.model.dto.request.PersonRequest;
import com.example.relationshipjpa.model.dto.response.ApiResponse;
import com.example.relationshipjpa.model.entity.Person;
import com.example.relationshipjpa.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final UserService userService;

    // get all user
    @Operation(summary = "get all user")
    @GetMapping
    ResponseEntity<ApiResponse<List<Person>>> getAllPerson() {
        ApiResponse<List<Person>> response = ApiResponse.<List<Person>>builder()
                .message("successfully get person")
                .payload(userService.getAllPerson())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // get user by id
    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<Person>> getPersonById(@PathVariable Long id){
        ApiResponse<Person> response = ApiResponse.<Person>builder()
                .message("successfully get person by their id")
                .payload(userService.getPersonById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // post user
    @Operation(summary = "post user")
    @PostMapping
    ResponseEntity<ApiResponse<Person>> postPerson(@RequestBody PersonRequest personRequest) {
        ApiResponse<Person> response = ApiResponse.<Person>builder()
                .message("success insert new user")
                .payload(userService.insertNewUser( personRequest))
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // update user
    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<Person>> updatePerson(@RequestBody PersonRequest updateInfo, @PathVariable Long id) {
        ApiResponse<Person> response = ApiResponse.<Person>builder()
                .message("Update person info successfully")
                .payload(userService.updateUser(id, updateInfo))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // delete user
    @Operation(summary = "delete user by id")
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Person>> deletePersonById(@PathVariable Long id) {
        ApiResponse<Person> response = ApiResponse.<Person>builder()
                .message("delete user successfully")
                .payload(userService.deleteUser(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
