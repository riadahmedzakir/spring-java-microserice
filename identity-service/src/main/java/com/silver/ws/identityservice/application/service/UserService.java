package com.silver.ws.identityservice.application.service;

import java.util.UUID;

import com.silver.ws.identityservice.application.shared.UserDto;

public class UserService implements IUserService {

    @Override
    public UserDto createUser(UserDto user) {
        user.setUserId(UUID.randomUUID().toString());
        return null;
    }

}
