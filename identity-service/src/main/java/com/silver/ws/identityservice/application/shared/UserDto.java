package com.silver.ws.identityservice.application.shared;

import java.io.Serializable;
import java.util.List;

import com.silver.ws.identityservice.application.models.AlbumResponseModel;

import lombok.Data;

public @Data class UserDto implements Serializable {
    private static final long serialVersionUID = 654645646874615L;

    private String FirstName;
    private String LastName;
    private String Email;
    private String userId;
    private String EncryptedPassword;
    private String Password;
    private List<AlbumResponseModel> albums;
}
