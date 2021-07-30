package com.codegym.model.service;

import com.codegym.model.entity.SmartPhone;

import java.util.Optional;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    void save(SmartPhone smartPhone);

    void remove(Long id);
}
