package com.spring.controllers;

import com.spring.domain.Contact;
import com.spring.repositories.ContactsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditContactController {
    private static final Logger log = Logger.getLogger(EditContactController.class);

    @Autowired
    ContactsRepository contactsRepository;

    @GetMapping("/editContact")
    public String editContact(@RequestParam(value = "contactId") Integer contactId, Model model){
        Contact contact = contactsRepository.findById(contactId);
        model.addAttribute("contact", contact);
        return "editContact";
    }

    @PostMapping("/editContact")
    public String saveEditedContact(@RequestParam(value = "contactId") Integer contactId, Contact contact){
        Contact contact1 = contactsRepository.findById(contactId);
        contact1.setName(contact.getName());
        contact1.setNumber(contact.getNumber());
        contactsRepository.save(contact1);
        log.info("Contact is edited");
        return "redirect:/";
    }
}
