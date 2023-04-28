package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.BookStoreDto;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.model.BookStore;


import java.util.List;

public interface BookService {
    ResponceDto addBook(BookStoreDto bookStoreDto);

    BookStore updateBook(int book_id ,BookStoreDto bookStoreDto);

    BookStore getById(int book_id);

    List<BookStore> getAllData();

    List<BookStore> getBookByName(String name);

    ResponceDto deleteById(int book_id);

    String changeBookPrice(String token, int book_id, float price);

    String changeBookQuantity(String token, int book_id, int quantity);
}
