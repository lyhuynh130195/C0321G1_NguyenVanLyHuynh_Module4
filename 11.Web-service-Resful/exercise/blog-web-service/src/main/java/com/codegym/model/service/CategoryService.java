package com.codegym.model.service;

import com.codegym.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAllCategory(int page, int size);

}
