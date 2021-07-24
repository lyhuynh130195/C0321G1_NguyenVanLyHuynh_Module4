package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void remove(Blog blog);

    Blog findById(int id);

    Blog findByName(String name);

    Page<Blog> findAllByCategoryID(Pageable pageable,int id);

    Page<Blog> findAllSearchName(Pageable pageable,String  keyword);


}
