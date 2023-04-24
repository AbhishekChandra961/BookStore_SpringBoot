package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.Login;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/adduser")
    public ResponseDto register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }
    @PutMapping("/varification")
    public ResponseDto validation(@RequestBody Verification verification ){
        return userService.varify(verification) ;
    }
    @PostMapping("/login")
    public ResponseDto login (@RequestBody Login login){
        return userService.login(login) ;
    }
}
