package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface CustomerService  {
    Page<Customer> findAllByName(Pageable pageable,String keyword);
    List<Customer> findAll();

    Optional<Customer> findById(int id);

    void save(Customer t);

    void remove(Customer t);
}
