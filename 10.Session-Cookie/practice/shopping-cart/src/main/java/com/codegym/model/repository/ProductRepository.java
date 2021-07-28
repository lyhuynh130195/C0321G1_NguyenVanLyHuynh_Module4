package com.codegym.model.repository;

import com.codegym.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
}
