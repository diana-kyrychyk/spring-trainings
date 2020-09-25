package com.example.demospring.service;

import com.example.demospring.domain.dto.UserDTO;
import com.example.demospring.domain.model.User;
import com.example.demospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), userDTO.getPassword());
        user = userRepository.save(user);
        return new UserDTO(user.getEmail(), user.getPassword());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByLoginIsNotNullOrderByFirstName();
    }


}
