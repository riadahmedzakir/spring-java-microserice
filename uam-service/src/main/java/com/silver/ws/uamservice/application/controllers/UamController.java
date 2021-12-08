package com.silver.ws.uamservice.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("uam")
public class UamController {

    @GetMapping("/status/check")
    public String status() {
        return "working";
    }
}
