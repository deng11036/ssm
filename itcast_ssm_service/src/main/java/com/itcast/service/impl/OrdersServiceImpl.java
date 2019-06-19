package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.OrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao ;

    @Override
    public List<Orders> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<Orders> ordersList = ordersDao.findAll();
        return ordersList;
    }

    @Override
    public Orders findById(String ordersid) {
        return ordersDao.findById(ordersid);
    }
}
