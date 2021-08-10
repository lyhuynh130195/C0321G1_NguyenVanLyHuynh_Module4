package com.codegym.model.repository;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select * " +
            "from contract_detail " +
            "where flags =1 and id=:keyworkValue", nativeQuery = true)
    Page<ContractDetail> findAllByIdAndFlags(Pageable pageable,@Param("keyworkValue") int keyword);

    @Query(value = "select * " +
            "from contract_detail " +
            "where flags =1 ", nativeQuery = true)
    Page<ContractDetail> findAllByFlags(Pageable pageable);
}
