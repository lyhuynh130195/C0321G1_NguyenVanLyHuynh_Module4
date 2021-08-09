package com.codegym.model.service.impl;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.repository.ContractDetailRepository;
import com.codegym.model.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    ContractDetailRepository contractDetailRepository;



    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAllByIdAndFlags(pageable);
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
}
