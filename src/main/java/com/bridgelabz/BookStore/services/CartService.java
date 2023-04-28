package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.CartDto;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.model.Cart;

import java.util.List;

public interface CartService {
    ResponceDto addCart(CartDto cartDto);

    ResponceDto removeCartById(int cartId);

    Cart getById(int cart_Id);

    ResponceDto getCartByToken(String token);

    ResponceDto updateBytoken(String token, int cart_id, int quantity);

    List<Cart> getAlldata();
}
