package com.codegym.model.service.impl;

import com.codegym.model.entity.Service;
import com.codegym.model.repository.ServiceRepository;
import com.codegym.model.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Optional<Service> findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public Page<Service> findAllByName(Pageable pageable, String keyword) {
        return serviceRepository.getCustomerBySearchingName(pageable, "%" + keyword + "%");
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
