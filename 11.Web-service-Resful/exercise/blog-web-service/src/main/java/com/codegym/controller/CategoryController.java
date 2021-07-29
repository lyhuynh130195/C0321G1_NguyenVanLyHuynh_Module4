package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.entity.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
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

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAllCategory(@PageableDefault(value = 3,sort = "date")Pageable pageable){
        Page<Category> categoryPage = categoryService.findAllCategory(pageable);
        if(categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Page<Blog>> findAllBlogByCategoryId(@PageableDefault(value = 3)Pageable pageable, @PathVariable int id){
        Page<Blog> blogPage = blogService.findAllBlogByCategoryID(pageable,id);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
}
