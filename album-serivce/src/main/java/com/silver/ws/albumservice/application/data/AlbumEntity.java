package com.silver.ws.albumservice.application.data;

import lombok.Data;

public @Data class AlbumEntity {
    private long id;
    private String albumId;
    private String userId;
    private String name;
    private String description;
}
