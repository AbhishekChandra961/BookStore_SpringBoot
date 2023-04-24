package com.bridgelabz.BookStore.dto;

import lombok.Data;

@Data
public class Verification {
    private String email;
    private int otp;
}
