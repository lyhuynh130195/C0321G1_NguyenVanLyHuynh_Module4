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
    public ModelAndView addition(@RequestParam double num1, double num2, String bt_type) {
        switch (bt_type) {
            case "addition":
                return new ModelAndView("index", "result", calculatorService.addition(num1, num2));
            case "subtract":
                return new ModelAndView("index", "result", calculatorService.subtraction(num1, num2));
            case "multiply":
                return new ModelAndView("index", "result", calculatorService.multiplication(num1, num2));
            case "division":
                return new ModelAndView("index", "result", calculatorService.division(num1, num2));
        }
        return null;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
