package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlog(@PageableDefault(value = 3,sort = "date")Pageable pageable){
        Page<Blog> blogPage = blogService.findAllBlog(pageable);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id){
        Optional<Blog> optionalBlog = blogService.findById(id);
        if(!optionalBlog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalBlog.get(),HttpStatus.OK);
    }
}
