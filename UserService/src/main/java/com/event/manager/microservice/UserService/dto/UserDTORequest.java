package com.event.manager.microservice.UserService.dto;

import com.event.manager.microservice.UserService.model.Role;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTORequest {

    private String firstName;
    private String lastName;
    @Size(min=11)
    private String phoneNumber;
    private String email;

    private String password;

    private Role role;

}
