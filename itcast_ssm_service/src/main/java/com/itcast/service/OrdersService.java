package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll(Integer page ,Integer size);

    Orders findById(String ordersid);
}
