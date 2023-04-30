package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.OrderDto;
import com.bridgelabz.BookStore.dto.ResponceDto;

public interface OrderService {
    ResponceDto placeOrder(OrderDto orderDto);


    ResponceDto getById(int orderId);

    ResponceDto getAllOrders();

    ResponceDto getByToken(String token);

    String cancelOrder(String token, int orderId);
}
