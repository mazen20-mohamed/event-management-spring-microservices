package com.event.manager.microservice.UserService.services;

import com.event.manager.microservice.UserService.dto.UserDTORequest;
import com.event.manager.microservice.UserService.dto.UserResponse;
import com.event.manager.microservice.UserService.exception.NotFoundException;
import com.event.manager.microservice.UserService.model.User;
import com.event.manager.microservice.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserDTORequest userDTORequest){
        User user = modelMapper.map(userDTORequest,User.class);

        user.setPassword(passwordEncoder.encode(userDTORequest.getPassword()));

        log.info("User has created {} , {}",user.getFirstName(),user.getEmail());
        userRepository.save(user);
    }

    public UserResponse getUserById(String userId){
        return modelMapper.map(getUserByIdWithCheck(userId),UserResponse.class);
    }

    public User getUserByIdWithCheck(String userId){
        return userRepository.findById(userId).orElseThrow(()->new NotFoundException("Not found a user with id" + userId));
    }

}
