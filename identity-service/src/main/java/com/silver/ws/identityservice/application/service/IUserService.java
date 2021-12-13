package com.silver.ws.identityservice.application.service;

import com.silver.ws.identityservice.application.shared.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService{
    UserDto createUser(UserDto user);
    UserDto getUserDetailsByEmail(String email);
}
