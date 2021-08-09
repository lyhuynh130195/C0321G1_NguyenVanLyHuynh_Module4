package com.codegym.model.service.impl;

import com.codegym.model.entity.Contract;
import com.codegym.model.repository.ContractRepository;
import com.codegym.model.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public Page<Contract> findAllByDate(Pageable pageable, String keyword) {
        return contractRepository.findAllByStartDateOrEnDate(pageable, "%" + keyword + "%");
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
