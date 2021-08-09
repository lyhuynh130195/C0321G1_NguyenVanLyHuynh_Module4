package com.codegym.model.service;

import com.codegym.model.entity.Employee;
import com.codegym.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService extends GeneralService<Service>{
    Page<Service> findAllByName(Pageable pageable, String keyword);

    List<Service> findAll();
}
