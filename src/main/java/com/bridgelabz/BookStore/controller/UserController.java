package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.Login;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
