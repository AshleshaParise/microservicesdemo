package com.springbootdemo.userservice;

import com.springbootdemo.userservice.entity.Contact;
import com.springbootdemo.userservice.entity.User;
import com.springbootdemo.userservice.service.UserService;
import com.springbootdemo.userservice.service.UserServiceImplementation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes={ServiceMockitoTest.class})
public class ServiceMockitoTest {


  @Mock
  UserService userService;

    @InjectMocks
    UserServiceImplementation userServiceImplementation;


    public List<User> user;

  @Test
  @Order(1)
  public void test_getAllUser(){
      List<User> user=new ArrayList<User>();
      user.add(new User(101,"Sonash","67467"));
      user.add(new User(102,"Ashson","63573"));
      user.add(new User(103,"Adam","37468"));
      Mockito.when(userService.getAllUser()).thenReturn(user);
      assertEquals(3,userServiceImplementation.getAllUser().size());
  }
    @Test
    @Order(2)
    public void test_getUser(){
        List<User> user=new ArrayList<User>();
        user.add(new User(101,"Sonash","67467"));
        user.add(new User(102,"Ashson","63573"));
        user.add(new User(103,"Adam","37468"));
        int userId=101;
        Mockito.when(userService.getAllUser()).thenReturn(user);

        assertEquals(userId=101,userServiceImplementation.getUser(userId).getUserId());
    }

    @Test
    @Order(3)
    public void test_addUser(){

        User user=new User(104,"Trisha","764990");
        Mockito.when(userService.addUser(user)).thenReturn(user);
        assertEquals(user,userServiceImplementation.addUser(user));

    }

    @Test
    @Order(4)
    public void test_updateUser(){

        User user=new User(104,"Trisha","764990");
        Mockito.when(userService.updateUser(user)).thenReturn(user);
        assertEquals(user,userServiceImplementation.updateUser(user));

    }

    @Test
    @Order(5)
    public void test_deleteUser(){

        int userId=103;

        Mockito.when(userService.deleteUser(userId)).thenReturn(true);
        assertEquals(true,userServiceImplementation.deleteUser(userId));
    }



}
