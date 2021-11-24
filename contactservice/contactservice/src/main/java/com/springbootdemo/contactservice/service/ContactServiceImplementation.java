package com.springbootdemo.contactservice.service;

import com.springbootdemo.contactservice.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImplementation implements ContactService {

    List<Contact> list;
    /*=List.of(
            new Contact(1011,"sonash@gmail.com","Son",101),
            new Contact(1012,"sona@gmail.com","Sonal",101),
            new Contact(1013,"ashson@gmail.com","Ash",102),
            new Contact(1014,"adam@gmail.com","Ada",103),
            new Contact(1015,"ada@gmail.com","Adal",103)

    );*/
    public ContactServiceImplementation(){
        list=new ArrayList<>();
                list.add(new Contact(1011,"sonash@gmail.com","Son",101));
                list.add(new Contact(1012,"sona@gmail.com","Sonal",101));
                list.add(new Contact(1013,"ashson@gmail.com","Ash",102));
                list.add(new Contact(1014,"adam@gmail.com","Ada",103));
                list.add(new Contact(1015,"ada@gmail.com","Adal",103));
    }
    @Override
    public List<Contact> getContactsOfUser(int userId) {
        return list.stream().filter(contact -> contact.getUserId()==userId).collect(Collectors.toList());
    }

    @Override
    public Contact addContact(Contact contact) {
        list.add(contact);
        return contact;
    }

    @Override
    public List<Contact> getAllUser() {
        return list;
    }

}
