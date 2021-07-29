package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllByCategory_Id(Pageable pageable,int id);
}
