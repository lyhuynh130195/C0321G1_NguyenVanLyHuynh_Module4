package com.codegym.model.service;

import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    void save(Category category);

    void remove(int id);

    Category findById(int id);

}
