package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> mapProducts;

    static {
        mapProducts = new HashMap<>();
        mapProducts.put(1, new Product(1, "Iphone 11", 1000, "phone", "Apple"));
        mapProducts.put(2, new Product(2, "Iphone 12", 1300, "phone", "Apple"));
        mapProducts.put(3, new Product(3, "Samsung Galaxy S21", 1200, "phone", "Samsung"));
        mapProducts.put(4, new Product(4, "Samsung Note 11", 1200, "phone", "Samsung"));
        mapProducts.put(5, new Product(5, "Smart TV 4k", 700, "tivi", "Samsung"));
        mapProducts.put(6, new Product(6, "Xiaomi 10", 600, "phone", "Xiaomi"));

    }

    @Override
    public void save(Product product) {
        mapProducts.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        mapProducts.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        mapProducts.put(id, product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(mapProducts.values());
    }

    @Override
    public Product findById(int id) {
        return mapProducts.get(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> productList = new ArrayList<>(mapProducts.values());
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
