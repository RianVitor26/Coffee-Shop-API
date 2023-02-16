package com.br.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.repositories.UserRepos;
import com.br.api.models.UserModel;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.OverridesAttribute.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")

public class UserController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping
    @Operation(summary = "Get all system users ", description = "return all user and status code 200")
    public String getAllUsers() {
        return "userRepos.findAll()";
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a system user", description = "return a user by ID and status code 200")
    public String getUserById() {
        return "User Id find";
    }

    @PostMapping
    @Operation(summary = "Create a user", description = "create a user by body and return status code 201")
    public String createUser() {
        return "Created User";
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update a user by ID", description = "update a user by ID and return status code 200")
    public String updateUser() {
        return "User Updated";
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a user", description = "delete a user and return status code 204")
    public String removeUser() {
        return "User deleted successfully"; 
    }
}
