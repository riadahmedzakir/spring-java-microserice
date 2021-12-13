package com.silver.ws.identityservice.application.models;

import lombok.Data;

public @Data class LoginRequestModel {
    private String Email;
    private String Password;
}
