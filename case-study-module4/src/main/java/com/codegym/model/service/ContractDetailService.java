package com.codegym.model.service;

import com.codegym.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService extends GeneralService<ContractDetail> {
    Page<ContractDetail> findAll(Pageable pageable,int keyword);

    public List<ContractDetail> findAll();
}
