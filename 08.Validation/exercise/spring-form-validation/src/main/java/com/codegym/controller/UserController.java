package com.codegym.controller;

import com.codegym.model.dto.UserDto;
import com.codegym.model.entyti.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/list")
    public String showList(){
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("userDto",userDto);
            return "create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("success","create new user successfully");
            return "redirect:/list";
        }
    }
}
