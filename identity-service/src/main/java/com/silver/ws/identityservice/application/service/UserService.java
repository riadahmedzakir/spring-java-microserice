package com.silver.ws.identityservice.application.service;

import java.util.UUID;

import com.silver.ws.identityservice.application.data.UserEntity;
import com.silver.ws.identityservice.application.shared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private UserRepository _userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto user) {
        user.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        _userRepository.save(userEntity);

        return null;
    }

}
