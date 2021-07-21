package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/list")
    public ModelAndView showList(){
        return new ModelAndView("list","listBlog",blogService.findAll());
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","blog",new Blog());
    }

    @PostMapping(value = "/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","create blog successfully");
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping(value = "/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("edit","blog",blogService.findById(id));
    }
    @PostMapping(value = "/update")
    public String update(Blog blog,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Update blog successfully");
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping(value = "/{id}/delete")
    public String reomve(@PathVariable int id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Delete blog successfully");
        blogService.remove(blogService.findById(id));
        return "redirect:/list";
    }

    @GetMapping(value = "/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        return new ModelAndView("view","blog",blogService.findById(id));
    }

}
