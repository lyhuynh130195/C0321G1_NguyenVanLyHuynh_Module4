package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll( pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog findByName(String name) {
        return blogRepository.findByName(name);
    }

    @Override
    public Page<Blog> findAllByCategoryID(Pageable pageable,int id) {
        return blogRepository.findAllByCategory_Id(pageable,id);
    }

    @Override
    public Page<Blog> findAllSearchName(Pageable pageable, String keyword) {
        return blogRepository.getBlogsBySearchingName(pageable,"%" + keyword + "%");
    }
}
