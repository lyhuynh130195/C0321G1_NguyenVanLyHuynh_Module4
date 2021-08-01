package com.codegym.model.service.impl;

import com.codegym.model.entity.Blog;
import com.codegym.model.repository.IBlogRepository;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAllByNameContaining(Pageable pageable, String title) {
        return iBlogRepository.findAllByNameContaining(pageable,title);
    }

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }


    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }


    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }



    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlogByCategory(Long category_id) {
        return this.iBlogRepository.findAllBlogByCategory(category_id);
    }

    @Override
    public List<Blog> findBlogByName(String name) {
        return this.iBlogRepository.findBlogByName(name);
    }
}
