package com.codegym.model.service;

import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService extends GeneralService<Employee>{
    Page<Employee> findAllByName(Pageable pageable, String keyword);

    List<Employee> findAll();

}
