package com.codegym.model.service;

import com.codegym.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findALl();

   Optional<Product> findById(Long id);
}
