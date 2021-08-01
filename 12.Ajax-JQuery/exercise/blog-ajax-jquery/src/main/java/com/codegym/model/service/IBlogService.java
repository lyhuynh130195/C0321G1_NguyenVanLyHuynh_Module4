package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllByNameContaining(Pageable pageable, String name);

    Page<Blog> findAll(Pageable pageable);;

}
