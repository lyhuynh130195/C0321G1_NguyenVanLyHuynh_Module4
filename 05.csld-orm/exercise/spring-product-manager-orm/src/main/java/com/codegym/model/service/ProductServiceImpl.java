package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product findOne(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
