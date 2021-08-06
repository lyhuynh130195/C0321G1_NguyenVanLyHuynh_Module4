package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * " +
            "from employee " +
            "where `name` like :keywordParam", nativeQuery = true)
    Page<Employee> getCustomerBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
}
