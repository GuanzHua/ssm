package com.guanzh.service;

import com.guanzh.domain.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int page, int size);

    Orders findById(String ordersId);
}
