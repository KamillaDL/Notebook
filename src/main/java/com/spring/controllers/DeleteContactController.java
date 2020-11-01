package com.spring.controllers;

import com.spring.domain.Contact;
import com.spring.repositories.ContactsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeleteContactController {
    private static final Logger log = Logger.getLogger(DeleteContactController.class);

    @Autowired
    ContactsRepository contactsRepository;

    @PostMapping("/deleteContact")
    public String deleteUser(@ModelAttribute(value = "id") String id) {
        System.out.println(id);
        Contact contact = contactsRepository.findById(Integer.parseInt(id));
        contactsRepository.delete(contact);
        log.info("Contact is deleted");
        return "redirect:/";
    }
}
