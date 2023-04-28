package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.Login;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/adduser")
    public ResponceDto register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }
    @PutMapping("/varification")
    public ResponceDto validation(@RequestBody Verification verification ){
        return userService.varify(verification) ;
    }
    @PostMapping("/login")
    public ResponceDto login (@RequestBody Login login){
        return userService.login(login) ;
    }
}