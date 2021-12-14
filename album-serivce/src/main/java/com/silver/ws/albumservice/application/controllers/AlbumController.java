package com.silver.ws.albumservice.application.controllers;

import java.util.ArrayList;
import java.util.List;

import com.silver.ws.albumservice.application.data.AlbumEntity;
import com.silver.ws.albumservice.application.model.AlbumResponseModel;
import com.silver.ws.albumservice.application.services.AlbumService;

import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumController {
    @Autowired
    AlbumService albumsService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {

        List<AlbumResponseModel> returnValue = new ArrayList<>();

        List<AlbumEntity> albumsEntities = albumsService.getAlbums(id);

        if (albumsEntities == null || albumsEntities.isEmpty()) {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>() {
        }.getType();

        returnValue = new ModelMapper().map(albumsEntities, listType);
        logger.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }
}
