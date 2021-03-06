package com.codegym.model.repository;

import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * " +
            "from contract " +
            "where flags =1 and concat(end_date,start_date) like :keywordParam", nativeQuery = true)
    Page<Contract> findAllByStartDateOrEnDate(Pageable pageable, @Param("keywordParam") String keyword);
}
