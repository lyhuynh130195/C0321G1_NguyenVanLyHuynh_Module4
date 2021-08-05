package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.Path;

public interface CustomerService extends GeneralService<Customer> {
    Page<Customer> findAllByName(Pageable pageable,String keyword);
}
