package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from blog where category_id = ?1",nativeQuery = true)
    List<Blog> findAllBlogByCategory(Long category_id);

    @Query(value = "select  * from blog where name like %?1%",nativeQuery = true)
    List<Blog> findBlogByName(String name);
}
