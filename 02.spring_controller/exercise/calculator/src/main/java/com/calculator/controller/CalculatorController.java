package com.calculator.controller;

import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @RequestMapping("/calculate")
    public ModelAndView addition(@RequestParam double num1, double num2, String calculateChoose) {
        return new ModelAndView("index", "result", calculatorService.calculate(num1, num2, calculateChoose));
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
