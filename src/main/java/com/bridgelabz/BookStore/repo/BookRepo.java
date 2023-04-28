package com.bridgelabz.BookStore.repo;

import com.bridgelabz.BookStore.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookStore,Integer> {
    @Query(value = "SELECT * FROM bookstoreapp.book_store where name = :name",nativeQuery = true)
    List<BookStore> getBookByName(String name);
}