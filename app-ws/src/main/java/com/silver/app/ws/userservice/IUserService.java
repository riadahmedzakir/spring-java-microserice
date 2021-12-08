package com.silver.app.ws.userservice;

import com.silver.app.ws.ui.models.request.UserRequest;
import com.silver.app.ws.ui.models.response.UserResponse;

public interface IUserService {
    UserResponse createUser(UserRequest userDetails);
}
