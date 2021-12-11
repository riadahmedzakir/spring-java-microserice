package com.silver.ws.identityservice.application.shared;

import java.io.Serializable;

import lombok.Data;

public @Data class UserDto implements Serializable {
    private static final long serialVersionUID = 654645646874615L;

    private String FirstName;
    private String LastName;
    private String Email;
    private String UserId;
    private String EncryptedPassword;
}
