package com.silver.app.ws.userservice;

import com.silver.app.ws.ui.models.request.UserRequest;
import com.silver.app.ws.ui.models.response.UserResponse;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public UserResponse createUser(UserRequest user) {
        UserResponse userCreated = new UserResponse();
        userCreated.setFirstName(user.getFirstName());
        userCreated.setLastName(user.getLastName());
        userCreated.setEmail(user.getEmail());
        userCreated.setUserId(user.getUserId());

        return userCreated;
    }

}
