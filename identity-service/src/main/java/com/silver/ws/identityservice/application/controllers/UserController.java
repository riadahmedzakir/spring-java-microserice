package com.silver.ws.identityservice.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("identity")
public class UserController {

    @GetMapping("/status/check")
    public String status(){
        return "working";
    }
}
