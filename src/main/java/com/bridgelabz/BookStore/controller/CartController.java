package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.CartDto;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.model.Cart;
import com.bridgelabz.BookStore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponceDto addCart(@RequestBody CartDto cartDto){
        return cartService.addCart(cartDto);
    }
    @DeleteMapping("/deletecart/{cart_id}")
    public ResponceDto removeCartById(@PathVariable long cart_id){
        return cartService.removeCartById(cart_id);
    }
    @GetMapping("/getcart/{cart_id}")
    public Cart getCartById(@PathVariable long cart_id){
        return cartService.getById(cart_id);
    }
    @GetMapping("/get/{token}")
    public ResponceDto getCartByToken(@PathVariable  String token){
        return cartService.getCartByToken(token);
    }
    @PutMapping("/update/{token}")
    public  ResponceDto updateQantity(@PathVariable String token,@RequestParam long cart_id, @RequestParam long quantity){
        return cartService.updateBytoken(token,cart_id,quantity);
    }
    @GetMapping("/getalldata")
    public List<Cart> getAllData(){
        return cartService.getAlldata();
    }

}