package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.exception.CustomException;
import com.bridgelabz.BookStore.model.BookStore;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.repo.BookRepo;
import com.bridgelabz.BookStore.repo.UserRepo;
import com.bridgelabz.BookStore.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTToken jwtToken;

    @Override
    public ResponseDto addBook(BookStoreDto bookStoreDto) {
        BookStore books=new BookStore(bookStoreDto);
        bookRepo.save(books);
        return new ResponseDto("The Book Detailes Added ",books) ;
    }

    @Override
    public BookStore updateBook(int id,BookStoreDto bookStoreDto) {
        BookStore bookStoreData=this.getById(id);
        bookStoreData.updateBook(bookStoreDto);
        return bookRepo.save(bookStoreData);
    }
    @Override
    public BookStore getById(int id) {
        return bookRepo.findById(id).orElseThrow(() -> new CustomException(" Data Not found .. wih id: "+ id));
    }

    @Override
    public List<BookStore> getAllData() {
        return bookRepo.findAll();
    }

    @Override
    public List<BookStore> getBookByName(String name) {
        List<BookStore> books =bookRepo.getBookByName(name);
        for (Object x:books) {
            System.out.println("The books "+x);
        }
        return books;
    }

    @Override
    public ResponseDto deleteById(int id) {
        BookStore book=this.getById(id);
        bookRepo.deleteById(id);
        return new ResponseDto("The Data has deleted",id);
    }
    @Override
    public String changeBookPrice( int id, float price) {
//        int idByToken = jwtToken.decodeToken(token);
        UserModel userData = userRepo.findById(id).orElseThrow(() -> new CustomException(" User not found with token :: "));
        BookStore bookData = bookRepo.findById(id).orElseThrow(() -> new CustomException(" Invalid Book ID,Please Try With Different ID"));
        bookData.setPrice(price);
        bookRepo.save(bookData);
        return "Successfully Changed the price";
    }
    @Override
    public String changeBookQuantity(int id,int quantity){
//        int idByToken = jwtToken.decodeToken(token);
        UserModel userData = userRepo.findById(id).orElseThrow(() -> new CustomException(" User not found with token :: "));
        BookStore bookData = bookRepo.findById(id).orElseThrow(() -> new CustomException(" Invalid Book ID,Please Try With Different ID"));
        bookData.setQuantity(quantity);
        bookRepo.save(bookData);
        return "Successfully Changed the quantity";
    }
}
