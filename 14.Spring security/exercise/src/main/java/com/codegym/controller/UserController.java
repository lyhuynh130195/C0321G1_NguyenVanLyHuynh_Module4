package com.codegym.controller;

import com.codegym.model.entity.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("user/create","user",new User());
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:blog/list";

    }
}
