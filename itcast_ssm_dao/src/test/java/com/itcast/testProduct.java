package com.itcast;

import com.itcast.dao.OrdersDao;
import com.itcast.dao.ProductDao;
import com.itcast.domain.Orders;
import com.itcast.domain.Product;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testProduct {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        ProductDao productDao = applicationContext.getBean(ProductDao.class);
        List<Product> productList = productDao.findAll();
        System.out.println(productList);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        OrdersDao ordersDao = applicationContext.getBean(OrdersDao.class);
        Orders orders = ordersDao.findById("5DC6A48DD4E94592AE904930EA866AFA");
        System.out.println(orders);
    }
}
