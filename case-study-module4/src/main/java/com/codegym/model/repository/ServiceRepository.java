package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select * " +
            "from service " +
            "where flags=1 and `name` like :keywordParam", nativeQuery = true)
    Page<Service> getCustomerBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
}
