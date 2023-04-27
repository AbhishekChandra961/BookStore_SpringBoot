package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.model.BookStore;


import java.util.List;

public interface BookService {
    ResponseDto addBook(BookStoreDto bookStoreDto);

    BookStore updateBook(int id ,BookStoreDto bookStoreDto);

    BookStore getById(int id);

    List<BookStore> getAllData();

    List<BookStore> getBookByName(String name);

    ResponseDto deleteById(int id);
    public String changeBookQuantity(int id,int quantity);
    public String changeBookPrice( int id, float price);
}
