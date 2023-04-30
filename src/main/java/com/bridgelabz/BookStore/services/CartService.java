package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.CartDto;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.model.Cart;

import java.util.List;

public interface CartService {
    ResponceDto addCart(CartDto cartDto);

    ResponceDto removeCartById(long cartId);

    Cart getById(long cart_Id);

    ResponceDto getCartByToken(String token);

    ResponceDto updateBytoken(String token, long cart_id,long quantity);

    List<Cart> getAlldata();
}
