package com.bridgelabz.BookStore.dto;

import lombok.Data;

@Data
public class BookStoreDto {
    public String name;
    public String author;
    public String description;
    public String logo;
    public Float price;
    public int quantity;
}
