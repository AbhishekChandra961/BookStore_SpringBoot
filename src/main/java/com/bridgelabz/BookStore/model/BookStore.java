package com.bridgelabz.BookStore.model;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue
    private int book_id;
    private String name;
    private String author;
    private String description;
    private String logo;
    private Float price;
    private int quantity;

    public void updateBook(BookStoreDto bookStoreDto){
        this.name=bookStoreDto.getName();
        this.author=bookStoreDto.getAuthor();
        this.description= bookStoreDto.getDescription();
        this.logo=bookStoreDto.getLogo();
        this.price= bookStoreDto.getPrice();
        this.quantity= bookStoreDto.getQuantity();
    }
    public BookStore(BookStoreDto bookStoreDto){
        this.updateBook(bookStoreDto);
    }
}