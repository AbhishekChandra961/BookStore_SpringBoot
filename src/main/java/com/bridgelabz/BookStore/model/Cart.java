package com.bridgelabz.BookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private long cart_id;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserModel userModel;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookStore bookStore;

    private  int quantity;
    public Cart(UserModel userModel , BookStore bookStore, int quantity) {
        this.userModel = userModel;
        this.bookStore = bookStore;
        this.quantity = quantity;
    }
}