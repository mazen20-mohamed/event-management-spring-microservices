package com.event.manager.microservice.UserService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String firstName;
    private String lastName;

    @Size(min=11)
    private String phoneNumber;

    @Column(nullable = false,unique = true)
    private String email;

    private String password;


    @Enumerated(value = EnumType.STRING)
    private Role role;



}
