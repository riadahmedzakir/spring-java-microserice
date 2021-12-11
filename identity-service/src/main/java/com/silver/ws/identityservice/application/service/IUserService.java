package com.silver.ws.identityservice.application.service;

import com.silver.ws.identityservice.application.shared.UserDto;

public interface IUserService {
    UserDto createUser(UserDto user);
}
