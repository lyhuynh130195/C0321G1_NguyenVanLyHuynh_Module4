package com.codegym.model.repository;

import com.codegym.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employee,Integer> {
}
