package com.springbootdemo.userservice.service;

import com.springbootdemo.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    List<User> list;
    /*=List.of(
            new User(101,"Sonash","67467"),
            new User(102,"Ashson","63573"),
            new User(103,"Adam","37468")
            );*/


    @Autowired
    private RestTemplate restTemplate;

    public UserServiceImplementation(){
        list=new ArrayList<>();
        list.add(new User(101,"Sonash","67467"));
        list.add(new User(102,"Ashson","63573"));
        list.add(new User(103,"Adam","37468"));
    }

    public void getContact(){

        list.forEach(e ->{
                    List contact=this.restTemplate.getForObject("http://contactservice/contact/user/"+e.getUserId(), List.class);
                    e.setContacts(contact);
                }
        );

    }


    @Override
    public List<User> getAllUser() {
       // getContact();
        return list;
    }

    @Override
    public User getUser(int id) {
        return this.list.stream().filter(user->user.getUserId()==id).findAny().orElse(null);
    }

    @Override
    public User addUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {

        list.forEach(e ->{
            if(e.getUserId() == user.getUserId()){
                e.setName(user.getName());
                e.setPhone(user.getPhone());
                e.setContacts(user.getContacts());
            }

                }
                );
        return user;
    }

    @Override
    public boolean deleteUser(int userId) {
        //list=this.list.stream().filter(e->e.getUserId()!=userId).collect(Collectors.toList());
        //return list;
        final boolean[] flag = new boolean[list.size()];
        list.removeIf(e -> e.getUserId() == userId);
        flag[0] = true;
        /*list.forEach(e ->{
                    if(e.getUserId() == userId)
                    {
                      list.remove(e);
                        flag[0] = true;
                    }
                }
        );*/
        return flag[0];
    }

   private String getMessage(String message){
        return message;

   }
    public String getMessageDetail(String msg) {
        return getMessage(msg);
    }
}
