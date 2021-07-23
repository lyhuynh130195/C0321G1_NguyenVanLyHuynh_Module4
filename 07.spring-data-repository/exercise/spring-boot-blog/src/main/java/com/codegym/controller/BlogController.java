package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 5,sort = "date") Pageable pageable,ModelMap modelMap){
        modelMap.addAttribute("listCategory",categoryService.findAll());
        return new ModelAndView("list_blog","listBlog", blogService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public ModelAndView create(ModelMap modelMap){
        modelMap.addAttribute("listCategory",categoryService.findAll());
        return new ModelAndView("create_blog","blog",new Blog());
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","create blog successfully");
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/{id}/edit")
    public ModelAndView edit(@PathVariable int id,ModelMap modelMap){
        modelMap.addAttribute("listCategory",categoryService.findAll());
        return new ModelAndView("edit_blog","blog",blogService.findById(id));
    }
    @PostMapping(value = "/update")
    public String update(Blog blog,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Update blog successfully");
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/{id}/delete")
    public String remove(@PathVariable int id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Delete blog successfully");
        blogService.remove(blogService.findById(id));
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        return new ModelAndView("view_blog","blog",blogService.findById(id));
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam String name,ModelMap modelMap,RedirectAttributes redirectAttributes){
        Blog blog = blogService.findByName(name);
        if(blog!=null){
            modelMap.addAttribute("blog",blog);
            return "view_blog";
        }else {
            redirectAttributes.addFlashAttribute("notFind","Not find blog");
            return "redirect:/blog/list";
        }
    }

    @PostMapping(value = "/select")
    public ModelAndView selectCategory(@PageableDefault(value = 5,sort = "date") Pageable pageable,@RequestParam int id,ModelMap modelMap){
        modelMap.addAttribute("listCategory",categoryService.findAll());
        return new ModelAndView("list_blog","listBlog",blogService.findAllByCategoryID(pageable,id));
    }

}
