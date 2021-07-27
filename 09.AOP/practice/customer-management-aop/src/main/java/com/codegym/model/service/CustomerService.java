package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void remove(Customer customer);

    Customer findById(int id);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Optional<Customer> findOne(int id) throws Exception;
}
