package com.bridgelabz.BookStore.model;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_store")
@Data
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private String description;

    private String logo;
    private Float price;
    private int quantity;

    public void updateBook(BookStoreDto bookDto){
        this.name=bookDto.getName();
        this.author=bookDto.getAuthor();
        this.description= bookDto.getDescription();
        this.logo=bookDto.getLogo();
        this.price= bookDto.getPrice();
        this.quantity= bookDto.getQuantity();
    }
    public BookStore(BookStoreDto bookStoreDto){
        this.updateBook(bookStoreDto);
    }


}
