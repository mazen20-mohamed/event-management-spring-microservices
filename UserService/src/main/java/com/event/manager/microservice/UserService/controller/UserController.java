package com.event.manager.microservice.UserService.controller;


import com.event.manager.microservice.UserService.dto.UserDTORequest;
import com.event.manager.microservice.UserService.dto.UserResponse;
import com.event.manager.microservice.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final Environment environment;

    @PostMapping
    public void registerUser(@RequestBody UserDTORequest userDTORequest){
        userService.registerUser(userDTORequest);
    }


    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @GetMapping
    public String get(){
        return environment.getProperty("message.name");
    }

}
