package com.bridgelabz.BookStore.services;

public interface PasswordReset {
    String forgotPassword(String email);

    String resetpassword(String email, String password);
}
