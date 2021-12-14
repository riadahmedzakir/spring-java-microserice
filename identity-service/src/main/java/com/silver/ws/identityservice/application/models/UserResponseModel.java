package com.silver.ws.identityservice.application.models;

import java.util.List;

import lombok.Data;

public @Data class UserResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<AlbumResponseModel> albums;
}
