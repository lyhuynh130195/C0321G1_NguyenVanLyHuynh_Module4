package com.codegym.model.service.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.CustomerRepository;
import com.codegym.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);

    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String keyword) {
        return customerRepository.getCustomerBySearchingName(pageable,"%" + keyword + "%");
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
