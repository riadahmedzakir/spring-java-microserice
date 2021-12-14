package com.silver.ws.albumservice.application.services;

import java.util.List;

import com.silver.ws.albumservice.application.data.AlbumEntity;

public interface IAlbumService {
    List<AlbumEntity> getAlbums(String userId);
}
