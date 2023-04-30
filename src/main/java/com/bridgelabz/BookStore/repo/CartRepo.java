package com.bridgelabz.BookStore.repo;

import com.bridgelabz.BookStore.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends org.springframework.data.jpa.repository.JpaRepository<Cart, Long> {
    @Query(value = "select * from bookstoreapp.cart where id = :userId",nativeQuery = true)
    Cart findDataById(long userId);
    @Query(value = "select * from bookstoreapp.cart where id = :id",nativeQuery = true)
    List<Cart> findDataByToken(long id);
//    @Query(value = "select cart_id from bookstoreapp.cart where id = :userId",nativeQuery = true)
//    int findIdByUserId(long userId);
    @Query(value = "select book_id from bookstoreapp.cart where id = :userId",nativeQuery = true)
    int findDataByUserId(long userId);
    @Query(value = "select * from bookstoreapp.cart where book_id = :bookId",nativeQuery = true)
    Optional<Cart> findDataByBookId(long bookId);
    @Query(value = "select * from cart where id = :x",nativeQuery = true)
    List<Cart> findAllDta(int x);
    @Query(value = "select * from cart where id = :userId and book_id = :bookId",nativeQuery = true)
    Cart findBookid(int bookId, int userId);
}
