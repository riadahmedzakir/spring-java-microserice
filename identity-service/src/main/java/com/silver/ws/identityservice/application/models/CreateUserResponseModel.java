package com.silver.ws.identityservice.application.models;

import lombok.Data;

public @Data class CreateUserResponseModel {
    private String FirstName;
    private String LastName;
    private String Email;
    private String userId;
}
