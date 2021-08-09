package com.codegym.model.service.impl;

import com.codegym.model.entity.Employee;
import com.codegym.model.repository.EmployRepository;
import com.codegym.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployRepository employRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByName(Pageable pageable, String keyword) {
        return employRepository.getCustomerBySearchingName(pageable,"%"+keyword+"%");
    }

    @Override
    public List<Employee> findAll() {
        return employRepository.findAll();
    }
}
