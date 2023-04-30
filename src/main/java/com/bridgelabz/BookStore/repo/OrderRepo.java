package com.bridgelabz.BookStore.repo;

import com.bridgelabz.BookStore.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends  org.springframework.data.jpa.repository.JpaRepository<Order, Integer>{
    @Query(value = "SELECT * FROM bookstoreapp.orders_table where user_id = :userId ",nativeQuery = true)
    List<Order> findByUserId(int userId);
}
