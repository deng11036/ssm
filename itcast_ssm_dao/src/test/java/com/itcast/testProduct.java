package com.itcast;

import com.itcast.dao.OrdersDao;
import com.itcast.dao.ProductDao;
import com.itcast.dao.RoleDao;
import com.itcast.dao.UserInfoDao;
import com.itcast.domain.Orders;
import com.itcast.domain.Product;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
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
        UserInfoDao userInfoDao = applicationContext.getBean(UserInfoDao.class);
        UserInfo lisi = userInfoDao.findByUsername("lisi");
        System.out.println(lisi);

//        RoleDao bean = applicationContext.getBean(RoleDao.class);
//        List<Role> roles = bean.findById("111-222");
//        System.out.println(roles);

    }
}
