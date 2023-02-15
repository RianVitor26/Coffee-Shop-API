package com.br.api.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/users", produces = "application/json")

public class UserController {

    @GetMapping
    @Operation(summary = "get all users", description = "return all users and status code 200")
    public String getAllUsers() {
        return "All Users";
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get a user", description = "return a user by id and status code 200")
    public String getUserById() {
        return "User Id find";
    }

    @PostMapping
    @Operation(summary = "create a user", description = "create a user, return user and status code 201")
    public String createUser() {
        return "Created User";
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "update a user", description = "update a user, return user and status code 200")
    public String updateUser() {
        return "User Updated";
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "update a user", description = "delete a user, return user and status code 200")
    public String removeUser() {
        return "User deleted successfully";
    }
}
