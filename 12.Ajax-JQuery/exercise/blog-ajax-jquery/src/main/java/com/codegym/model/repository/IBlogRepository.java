package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllByNameContaining(Pageable pageable, String name);
    Page<Blog> findAll(Pageable pageable);

}
