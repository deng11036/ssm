package com.itcast.service.impl;

import com.itcast.dao.ProductDao;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @RolesAllowed("WWWW")
    public void save(Product product) {
        productDao.save(product);
    }
}
