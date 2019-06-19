package com.itcast.dao;

import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersDao {
    //查询所有订单信息
    public List<Orders> findAll();
    //根据订单id查询订单、旅客、会员信息
    public Orders findById(String ordersid);
}
