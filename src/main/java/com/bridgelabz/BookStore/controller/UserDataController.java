package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserDataController {
    List<UserModel> list=new ArrayList<>();

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseDto getDataByid(@PathVariable int id){
        UserModel addressBookData = userService.getById(id);
        ResponseDto responceDto = new ResponseDto("Data is",addressBookData);
        return responceDto;
    }
    @GetMapping("/")
    public ResponseDto getAllData(){
        List<UserModel> data=userService.getAllData();
        ResponseDto responceDto =new ResponseDto("The All Employees ",data);
        return responceDto;
    }
    @PutMapping("/update/{id}")
    public ResponseDto update(@RequestBody UserDto userDto, @PathVariable int id){
        UserModel addressBookData =userService.UpdateEmployee(id,userDto);
        ResponseDto responceDto = new ResponseDto("Data is",addressBookData);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable int id){
        userService.delete(id);
        return "Deleted the data from the id"+id;
    }
    @GetMapping("/token/{token}")
    public ResponseEntity<ResponseDto> getDataByToken(@PathVariable String token){
        UserModel userData=userService.getdataByToken(token);
        ResponseDto responceDto = new ResponseDto("Data for the token is-",userData);

        return new ResponseEntity<>(responceDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/deletetoken/{token}")
    public ResponseEntity<ResponseDto> deleteDataByToken(@PathVariable String token){
        String userData=userService.deletedataByToken(token);
        ResponseDto responceDto = new ResponseDto("Data is deleted",userData);
        return new ResponseEntity<>(responceDto, HttpStatus.CREATED);
    }
}
