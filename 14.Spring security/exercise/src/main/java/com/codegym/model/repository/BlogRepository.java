package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findByName(String name);

    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select * " +
            "from blog " +
            "where `name` like :keywordParam", nativeQuery = true)
    Page<Blog> getBlogsBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);

    Page<Blog> findAllByCategory_Id(Pageable pageable, int id);
}
