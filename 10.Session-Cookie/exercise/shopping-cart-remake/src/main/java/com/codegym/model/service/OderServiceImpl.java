package com.codegym.model.service;

import com.codegym.model.entity.Oder;
import com.codegym.model.repository.OderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderServiceImpl implements OderService{
    @Autowired
    OderRepository oderRepository;
    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }
}
