package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import com.dictionary.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
@Autowired
    DictionaryService dictionaryService;

    @RequestMapping(value = "")
    public String home() {
        return "index";
    }

@PostMapping(value = "/translate")
    public ModelAndView translate(@RequestParam  String english ){
        return new ModelAndView("index","result",dictionaryService.findVieByEng(english));
}

}
