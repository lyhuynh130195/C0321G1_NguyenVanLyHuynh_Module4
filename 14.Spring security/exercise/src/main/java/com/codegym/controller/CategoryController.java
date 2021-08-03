package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 5)Pageable pageable){

        return new ModelAndView("list_category","listCategory",categoryService.findAll(pageable));
    }

    @GetMapping(value = "/{id}/listBlog")
    public ModelAndView showListBlog(@PageableDefault(value = 5)Pageable pageable, @PathVariable int id){
        return new ModelAndView("view_category","listBlog",blogService.findAllByCategoryID(pageable,id));
    }

    @GetMapping(value = "/create")
    public ModelAndView create(){
        return new ModelAndView("create_category","category",new Category());
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping(value = "/{id}/delete")
    public String remove(@PathVariable int id){
        categoryService.remove(id);
        return "redirect:/category/list";
    }

    @GetMapping(value = "/{id}/edit")
    public ModelAndView showFormedit(@PathVariable int id){
        return new ModelAndView("edit_category","category",categoryService.findById(id));
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category/list";
    }

}
