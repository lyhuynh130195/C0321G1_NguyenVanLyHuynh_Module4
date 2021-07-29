package com.codegym.model.service;

import com.codegym.model.entity.Customer;

import java.util.Optional;

public interface GeneralService<T>{

    Iterable<T> findAll();

    Optional<T> findOne(Long id);

    T save(T customer);

    void remove(Long id);
}
