package com.bridgelabz.BookStore.model;

import com.bridgelabz.BookStore.services.BookService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders_table")
public class Order {
    @Id
    @GeneratedValue
    private int order_id;
    private LocalDate orderDate;
    private int quantity;
    private Float price;
    private String address;
    private int user_id;
    private float totalPrice;

    @JsonIgnoreProperties(value = {"application","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookStore bookStore;
    private Boolean cancel = false;

    public Order(int user_id,int quantity,BookStore bookStore,Float price,String address,float totalPrice,LocalDate orderDate){
        this.user_id=user_id;
        this.quantity=quantity;
        this.bookStore=bookStore;
        this.price=price;
        this.address=address;
        this.totalPrice=totalPrice;
        this.orderDate=orderDate;
    }

}
