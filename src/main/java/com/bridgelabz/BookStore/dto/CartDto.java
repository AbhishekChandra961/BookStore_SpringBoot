package com.bridgelabz.BookStore.dto;

import lombok.Data;

@Data
public class CartDto {
    public String token;
    public long book_id;
    public long quantity;
}
