package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);

    Optional<Blog> findById(int id);

    Page<Blog> findAllBlogByCategoryID(Pageable pageable,int id);

    void save(Blog blog);

    void delete(Blog blog);
}
