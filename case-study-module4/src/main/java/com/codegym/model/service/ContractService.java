package com.codegym.model.service;

import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService extends GeneralService<Contract>{
    Page<Contract> findAllByDate(Pageable pageable,String keyword);

    List<Contract> findAll();
}
