package com.spring.controllers;

import com.spring.domain.Role;
import com.spring.domain.User;
import com.spring.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    private static final Logger log = Logger.getLogger(RegistrationController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String AddUser(User user, Model model){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB != null){
            model.addAttribute("userExists", "User already exist!");
            log.info("User already exist");
            return "registration";
        }
        Boolean isNotEmpty = user.Validate();
        if(!isNotEmpty){
            model.addAttribute("invalidData", "Your input data is invalid");
            log.info("Input data is invalid");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        log.info("User successfully added");
        return "redirect:/login";
    }
}
