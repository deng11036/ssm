package com.itcast.service;

import com.itcast.domain.Product;

import java.util.List;

/**
 * 商品服务类接口
 */
public interface ProductService {
    public List<Product> findAll();

    void save(Product product);
}
