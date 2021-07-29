package com.codegym.model.service;

import com.codegym.model.entity.Category;
import com.codegym.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAllCategory(@PageableDefault(value = 3,sort = "date")Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
