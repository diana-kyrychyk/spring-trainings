package com.example.demospring.controller;

import com.example.demospring.domain.dto.UserDTO;
import com.example.demospring.domain.model.User;
import com.example.demospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user-registration")
    public ModelAndView getUserRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDto = new UserDTO();
        modelAndView.addObject("userDto", userDto);
        modelAndView.setViewName("user/user-registration");
        return modelAndView;
    }

    @PostMapping(value = "/user-registration")
    public ModelAndView doUserRegistration(@ModelAttribute("userDto") UserDTO userDto, Locale locale) {
        userService.createUser(userDto);
        return new ModelAndView("index");
    }

    @GetMapping(value = "/user-list")
    public ModelAndView showUserList() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.findAll();
        modelAndView.addObject("users", userList);
        modelAndView.setViewName("user/user-list");
        return modelAndView;
    }

}
