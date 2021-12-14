package com.silver.ws.identityservice.application.data;

import java.util.List;

import com.silver.ws.identityservice.application.models.AlbumResponseModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "albums-service")
public interface AlbumServiceClient {
    @GetMapping("/users/{id}/albums")
    public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}
