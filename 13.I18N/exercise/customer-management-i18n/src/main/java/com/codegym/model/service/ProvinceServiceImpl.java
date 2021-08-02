package com.codegym.model.service;

import com.codegym.model.entity.Province;
import com.codegym.model.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Province province) {
        provinceRepository.delete(province);
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).get();
    }
}
