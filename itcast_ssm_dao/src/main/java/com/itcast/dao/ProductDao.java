package com.itcast.dao;

import com.itcast.domain.Product;

import java.util.List;

/**
 * 商品接口
 */
public interface ProductDao {

    public List<Product> findAll();

    void save(Product product);
}
