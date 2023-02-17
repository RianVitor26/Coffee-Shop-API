package com.br.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.api.repositories.UserRepos;
import com.br.api.models.UserModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
@CrossOrigin(origins = "*") // Trocar para o domínio do front quando existir

public class UserController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping
    @Operation(summary = "Get all system users ", description = "return all user and status code 200")
    public List<UserModel> getAllUsers() {
        try {
            return userRepos.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a system user", description = "return a user by ID and status code 200")
    public UserModel getUserById(@PathVariable Long id) {
        try {
            return userRepos.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @PostMapping
    @Operation(summary = "Create a user", description = "create a user by body and return status code 201")
    @ResponseStatus(HttpStatus.CREATED)

    public UserModel createUser(@RequestBody UserModel user) {
        try {
            return userRepos.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update a user by ID", description = "update a user by ID and return status code 200")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user) {
        try {
            if (!userRepos.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            } else {
                user.setId(id);
                return userRepos.save(user);
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating user", e);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a user", description = "delete a user and return status code 204")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Long id) {
        try {
            if (!userRepos.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            } else {
                userRepos.deleteById(id);
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating user", e);
        }
    }
}
