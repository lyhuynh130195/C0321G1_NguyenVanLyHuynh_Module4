package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.entity.Category;
import com.codegym.model.service.IBlogService;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/blog/api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> name) {
        String keywordName = "";
        if (name.isPresent()) {
            keywordName = name.get();
        }
        Page<Blog> blogList = blogService.findAllByNameContaining(pageable, keywordName);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}

