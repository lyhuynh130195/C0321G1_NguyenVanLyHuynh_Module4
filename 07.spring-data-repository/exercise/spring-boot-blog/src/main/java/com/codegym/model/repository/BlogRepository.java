package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findByName(String name);

    Page<Blog> findAll( Pageable pageable);

    Page<Blog> findAllByCategory_Id(Pageable pageable,int id);
}
