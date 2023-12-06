package com.igaogl.moviemaster.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.igaogl.moviemaster.model.User;
import com.igaogl.moviemaster.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    private @Autowired UserService userService;

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> userList = userService.findAllUsers();
            return ResponseEntity.status(200).body(userList);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            User createdUser = userService.createUser(user)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User creation failed"));
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
    }

}
