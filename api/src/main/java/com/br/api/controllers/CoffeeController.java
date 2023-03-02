package com.br.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.api.repositories.CoffeeRepos;
import com.br.api.models.CoffeeModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {


    @Autowired
    private CoffeeRepos coffeeRepos;
    

    @GetMapping
    @Operation(summary = "Get all coffee ", description = "return all coffee and status code 200")
    public List<CoffeeModel> getAllUsers() {
        try {
            return coffeeRepos.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a coffee", description = "return a coffee and status code 200")
    public CoffeeModel getUserById(@PathVariable Long id) {
        try {
            return coffeeRepos.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @PostMapping
    @Operation(summary = "Create a coffee", description = "create a coffee by body and return status code 201")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeModel createUser(@RequestBody CoffeeModel user) {
        try {
            return coffeeRepos.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving users", e);
        }
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update a coffee by ID", description = "update a coffee by ID and return status code 200")
    public CoffeeModel updateUser(@PathVariable Long id, @RequestBody CoffeeModel user) {
        try {
            if (!coffeeRepos.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            } else {
                user.setId(id);
                return coffeeRepos.save(user);
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating user", e);
        }
    }
    
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a coffee", description = "delete a coffee and return status code 204")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Long id) {
        try {
            if (!coffeeRepos.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            } else {
                coffeeRepos.deleteById(id);
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating user", e);
        }
    }

}
