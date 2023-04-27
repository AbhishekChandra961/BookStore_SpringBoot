package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.model.BookStore;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.services.BookService;
import com.bridgelabz.BookStore.services.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookStoreController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseDto addBook(@RequestBody BookStoreDto bookStoreDto){
        return bookService.addBook(bookStoreDto);
    }
    @PutMapping("/update/{id}")
    public BookStore updateBook(@PathVariable int id , @RequestBody BookStoreDto bookStoreDto){
        return bookService.updateBook(id,bookStoreDto);
    }
    @GetMapping("/{id}")
    public BookStore getById(@PathVariable int id){
        return bookService.getById(id);
    }
    @GetMapping("/allbooks")
    public  ResponseDto getAllData(){
        List<BookStore> books=bookService.getAllData();
        return new ResponseDto("The all Books Present In Store",books);
    }
    @GetMapping("/bookname")
    public List<BookStore> getBookByName(@RequestParam String name){
        return bookService.getBookByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteDataById(@PathVariable int id){
        return bookService.deleteById(id);
    }
    @PostMapping("/changeQuantityBook")
    public String changeQuantity( @RequestParam int id, @RequestParam int quantity) {
        return bookService.changeBookQuantity( id, quantity);
    }
    @PostMapping("/changePriceBook")
    public String changePrice(@RequestParam int id, @RequestParam float price) {
        return bookService.changeBookPrice( id, price);
    }

}
