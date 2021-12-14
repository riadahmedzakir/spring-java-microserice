package com.silver.ws.identityservice.application.models;

import lombok.Data;

public @Data class AlbumResponseModel {
    private String albumId;
    private String userId;
    private String name;
    private String description;
}
