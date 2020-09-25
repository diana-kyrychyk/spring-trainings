package com.example.demospring.service;

import com.example.demospring.domain.dto.UserDTO;
import com.example.demospring.domain.model.User;

import java.util.List;

public interface UserService {


    UserDTO createUser(UserDTO userDTO);

    List<User> findAll();


}
