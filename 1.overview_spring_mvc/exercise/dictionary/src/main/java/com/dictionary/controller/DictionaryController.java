package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import com.dictionary.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView translate(@RequestParam String english) {
        String result = dictionaryService.findVieByEng(english);
        if (result == "") {
            return new ModelAndView("index", "resultNotfound", "không tìm thấy");
        }
        return new ModelAndView("index", "result", result);
    }

    @GetMapping(value = "/swap")
    public String swap(Model model) {
        return "swap";
    }

    @PostMapping(value = "swap/translate")
    public ModelAndView translateSwap(@RequestParam String vietNamese) {
        String result = dictionaryService.finEngByVie(vietNamese);
        if (result == "") {
            return new ModelAndView("swap", "resultNotfound1", "không tìm thấy");
        }
        return new ModelAndView("swap", "result1", result);
    }
}

