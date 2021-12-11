package com.silver.ws.identityservice.application.controllers;

import javax.validation.Valid;

import com.silver.ws.identityservice.application.models.CreateUserRequestModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("identity")
public class UserController {

    @GetMapping("/status/check")
    public String status(){
        return "working";
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel user){
        return "...";
    }
}
