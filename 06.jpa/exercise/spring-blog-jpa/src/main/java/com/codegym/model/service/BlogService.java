package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(Blog blog);
}
