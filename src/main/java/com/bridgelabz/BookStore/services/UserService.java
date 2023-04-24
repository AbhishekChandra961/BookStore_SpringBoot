package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.Login;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllData() ;

    ResponseDto login(Login login) ;

    ResponseDto varify(Verification verification) ;

    ResponseDto register(UserDto userDto);

    UserModel getById(int id);

    UserModel UpdateEmployee(int id, UserDto userDto);

    void delete(int id);

    UserModel getdataByToken(String token);

    String deletedataByToken(String token);
}
