package com.silver.ws.identityservice.application.service;

import com.silver.ws.identityservice.application.data.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String Email);
}
