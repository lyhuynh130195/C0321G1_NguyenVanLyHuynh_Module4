package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);

    void delete(int id);

    Product update(Product product);

    Product findOne(int id);

    List<Product> findAll();

    Product findByName(String name);
}
