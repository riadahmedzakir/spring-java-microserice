package com.silver.ws.identityservice.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.silver.ws.identityservice.application.data.UserEntity;
import com.silver.ws.identityservice.application.models.AlbumResponseModel;
import com.silver.ws.identityservice.application.shared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.userdetails.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService implements IUserService {
    private UserRepository _userRepository;
    private BCryptPasswordEncoder _bCryptPasswordEncoder;
    private Logger _logger;
    private Environment _environment;
    private RestTemplate _restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
            RestTemplate restTemplate, Environment environment) {
        this._userRepository = userRepository;
        this._bCryptPasswordEncoder = bCryptPasswordEncoder;
        this._restTemplate = restTemplate;
        this._environment = environment;
        this._logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public UserDto createUser(UserDto user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setEncryptedPassword(_bCryptPasswordEncoder.encode(user.getPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        _userRepository.save(userEntity);
        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = _userRepository.findByEmail(username);

        if (userEntity == null)
            throw new UsernameNotFoundException(username);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
                new ArrayList<>());
    }

    @Override
    public UserDto getUserDetailsByEmail(String userName) {
        UserEntity userEntity = _userRepository.findByEmail(userName);

        if (userEntity == null)
            throw new UsernameNotFoundException(userName);

        return new ModelMapper().map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = _userRepository.findByUserId(userId);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
        
        String albumUrlVariable = _environment.getProperty("albums.url");
        String albumsUrl = String.format(albumUrlVariable, userId);

        ResponseEntity<List<AlbumResponseModel>> albumsListResponse = _restTemplate.exchange(albumsUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {
                });

        _logger.info("Before calling albums Microservice");

        List<AlbumResponseModel> albumsList = albumsListResponse.getBody();

        _logger.info("After calling albums Microservice");

        userDto.setAlbums(albumsList);

        return userDto;
    }

}
