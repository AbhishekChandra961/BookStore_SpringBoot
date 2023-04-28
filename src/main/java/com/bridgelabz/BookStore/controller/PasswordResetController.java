package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.services.PasswordReset;
import com.bridgelabz.BookStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordResetController {
    @Autowired
    private PasswordReset passwordReset;
    @Autowired
    private UserService regstationService;
    @PostMapping("/forgot")
    public String forgetPassword(@RequestParam String email){
        return passwordReset.forgotPassword(email);
    }
    @PutMapping("/reset")
    public String resetPassword(@RequestParam String email,@RequestParam String password){
        return passwordReset.resetpassword(email,password);
    }
    @PutMapping("/varify")
    public ResponceDto validation(@RequestBody Verification validation ){
        return regstationService.varify(validation);
    }
}
