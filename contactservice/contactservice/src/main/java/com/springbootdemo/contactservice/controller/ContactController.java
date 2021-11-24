package com.springbootdemo.contactservice.controller;

import com.springbootdemo.contactservice.entity.Contact;
import com.springbootdemo.contactservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/user/{userId}")
    public List<Contact> getContact(@PathVariable("userId") int userId){

        return this.contactService.getContactsOfUser(userId);
    }

    @PostMapping("/user")
    public Contact addUser(@RequestBody Contact contact)
    {
        return this.contactService.addContact(contact);
    }

    @GetMapping("/user")
    public List<Contact> getAllUsers(){
        return contactService.getAllUser();
    }




}
