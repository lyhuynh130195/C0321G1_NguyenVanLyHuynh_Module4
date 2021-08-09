package com.codegym.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(int id);


    void save(T t);

    void remove(T t);
}
