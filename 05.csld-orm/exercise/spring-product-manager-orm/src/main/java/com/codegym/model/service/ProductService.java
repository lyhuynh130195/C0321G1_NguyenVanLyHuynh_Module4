package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    void delete(int id);

    Product update(Product product);

    Product findOne(int id);

    List<Product> findAll();

    Product findByName(String name);
}
