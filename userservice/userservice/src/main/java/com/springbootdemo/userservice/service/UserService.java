package com.springbootdemo.userservice.service;

import com.springbootdemo.userservice.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getUser(int id);

    public User addUser(User user);

   public User updateUser(User user);

    public boolean deleteUser(int userId);
}
