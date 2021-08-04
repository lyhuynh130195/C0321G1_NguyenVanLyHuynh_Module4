package com.codegym.controller;

import com.codegym.model.entity.User;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import com.codegym.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("user/create","user",new User());
    }
    @PostMapping(value = "/save")
    public ModelAndView save(@PageableDefault Pageable pageable, @ModelAttribute User user, ModelMap modelMap){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        modelMap.addAttribute("listCategory", categoryService.findAll());
        return new ModelAndView("list_blog", "listBlog", blogService.findAll(pageable));

    }
}
