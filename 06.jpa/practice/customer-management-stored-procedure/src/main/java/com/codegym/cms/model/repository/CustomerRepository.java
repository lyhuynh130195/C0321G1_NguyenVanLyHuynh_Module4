package com.codegym.cms.model.repository;

import com.codegym.cms.model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Long id);

    boolean insertWithStoredProcedure(Customer customer);

    void remove(Long id);
}
