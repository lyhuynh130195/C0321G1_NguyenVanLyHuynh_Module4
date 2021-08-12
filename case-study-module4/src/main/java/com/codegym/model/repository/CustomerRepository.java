package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * " +
            "from customer " +
            "where flags=1 and `name` like :keywordParam", nativeQuery = true)
    Page<Customer> getCustomerBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
}
