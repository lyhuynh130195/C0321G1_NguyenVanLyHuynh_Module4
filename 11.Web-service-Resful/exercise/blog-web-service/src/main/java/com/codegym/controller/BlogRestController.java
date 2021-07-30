package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.entity.Blog;
import com.codegym.model.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/blog")
public class BlogRestController {
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/get-all")
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


    @PostMapping(value = "/create")
    public ResponseEntity<Void> saveBlog(@RequestBody BlogDto blogDto){
        if(blogDto==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int id){
        Optional<Blog> optionalBlog = blogService.findById(id);
        if(!optionalBlog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(optionalBlog.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBlog(@PathVariable int id,@RequestBody BlogDto blogDto){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = blogOptional.get();
        BeanUtils.copyProperties(blogDto,blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }
}
