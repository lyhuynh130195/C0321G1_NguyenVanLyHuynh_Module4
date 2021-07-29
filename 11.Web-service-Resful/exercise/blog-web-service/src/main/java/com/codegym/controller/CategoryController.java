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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<Page<Category>> findAllCategory(@RequestParam int page,
                                                          @RequestParam int size){
        Page<Category> categoryPage = categoryService.findAllCategory(page, size);
        if(categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }
    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Page<Blog>> findAllBlogByCategoryId(@PageableDefault(value = 3)Pageable pageable, @PathVariable int categoryId){
        Page<Blog> blogPage = blogService.findAllBlogByCategoryID(pageable,categoryId);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
}
