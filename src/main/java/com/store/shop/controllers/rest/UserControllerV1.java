package com.store.shop.controllers.rest;

import com.store.shop.entities.User;
import com.store.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserControllerV1
{
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/new-user")
//    public ResponseEntity<User> addUser(@RequestBody User user)
//    {
//        try
//        {
//            userService.addNewUser(user);
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
