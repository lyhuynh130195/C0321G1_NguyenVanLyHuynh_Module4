package com.codegym.controller;

import com.codegym.model.ConfigurationEmail;
import com.codegym.service.ConfigurationEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigurationEmailController {

    @Autowired
    ConfigurationEmailService configurationEmailService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "setting" ,method = RequestMethod.GET)
    public ModelAndView showSetting(){
        return new ModelAndView("setting","configurationEmail", configurationEmailService.getConfiguration());
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("configurationEmail") ConfigurationEmail configurationEmail){
        configurationEmailService.updateConfigurationEmail(configurationEmail);
        return new ModelAndView("showSetting","configurationEmail", configurationEmail);
    }
}
