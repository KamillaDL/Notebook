package com.spring.controllers;

import com.spring.domain.Contact;
import com.spring.domain.User;
import com.spring.repositories.ContactsRepository;
import com.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class ContactsController {
    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String contacts(@RequestParam(defaultValue = "0") Integer page, Principal principal, Model model){
        User user = userRepository.findByUsername(principal.getName());
        Pageable pageable = PageRequest.of(page, 5, Sort.by("name"));
        Page<Contact> page1 = contactsRepository.findByUserId(user.getId(), pageable);
        model.addAttribute("page", page1);
        model.addAttribute("currentPage", page);
        return "contacts";
    }
}
