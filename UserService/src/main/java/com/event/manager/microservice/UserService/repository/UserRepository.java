package com.event.manager.microservice.UserService.repository;

import com.event.manager.microservice.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
