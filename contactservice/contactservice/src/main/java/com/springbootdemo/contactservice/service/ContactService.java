package com.springbootdemo.contactservice.service;

import com.springbootdemo.contactservice.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactsOfUser(int userId);
    public Contact addContact(Contact contact);

    public List<Contact> getAllUser();


}
