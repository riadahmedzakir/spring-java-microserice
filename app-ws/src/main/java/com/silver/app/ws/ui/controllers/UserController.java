package com.silver.app.ws.ui.controllers;

import javax.validation.Valid;

import com.silver.app.ws.ui.models.request.UserRequest;
import com.silver.app.ws.ui.models.response.UserResponse;
import com.silver.app.ws.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit", defaultValue = "10", required = false) int limit) {
        return "get user was called";
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
        UserResponse user = new UserResponse();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email");
        user.setUserId("userId");

        return new ResponseEntity<UserResponse>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest user) {
        UserResponse userCreated = userService.createUser(user);

        return new ResponseEntity<UserResponse>(userCreated, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
