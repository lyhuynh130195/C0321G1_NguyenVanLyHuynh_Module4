package com.codegym.model.service;


import com.codegym.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    void save(Province province);

    void remove(Province province);

    Province findById(int id);
}
