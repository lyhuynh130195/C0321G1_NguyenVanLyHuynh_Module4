package com.spice_sandwich.controller;

import com.spice_sandwich.service.SpiceSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpiceSandwichController {
    @Autowired
    SpiceSandwichService spiceSandwichService;

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(@RequestParam("condiment") String[] condiments){
        return new ModelAndView("view","listSpice",spiceSandwichService.saveSpice(condiments));
    }
}
