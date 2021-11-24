package com.springbootdemo.userservice.controller;

import com.springbootdemo.userservice.entity.User;
import com.springbootdemo.userservice.service.UserService;
import com.springbootdemo.userservice.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/alluser")
    public List<User> getAllUsers(){
        List<User> list=new ArrayList<> ();
        list=userService.getAllUser();
        list.forEach(e ->{
                    List contact=this.restTemplate.getForObject("http://contactservice/contact/user/"+e.getUserId(), List.class);
                    e.setContacts(contact);
                }
        );

        return list;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") int userId){
        User user=this.userService.getUser(userId);
        List contact=this.restTemplate.getForObject("http://contactservice/contact/user/"+user.getUserId(), List.class);
        user.setContacts(contact);
        return user;
    }

    @PostMapping("/alluser")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/alluser")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/alluser/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") int userId){

            try {
                this.userService.deleteUser(userId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

}
