package com.spring.controllers;

import com.spring.domain.Contact;
import com.spring.domain.User;
import com.spring.repositories.ContactsRepository;
import com.spring.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AddNewContactController {
    private static final Logger log = Logger.getLogger(AddNewContactController.class);

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/addNewContact")
    public String add(){
        return "addContact";
    }

    @PostMapping("/addNewContact")
    public String addNewContact(Contact contact, Model model, Principal principal){
        Boolean isNotEmpty = contact.Validate();
        if(!isNotEmpty){
            model.addAttribute("invalidData", "Your input data is invalid");
            log.info("Input data is invalid");
            return "addContact";
        }
        model.addAttribute("add", "Contact is added");
        log.info("Contact is added");
        User user = userRepository.findByUsername(principal.getName());
        contact.setUser(user);
        contactsRepository.save(contact);
        return "addContact";
    }
}
