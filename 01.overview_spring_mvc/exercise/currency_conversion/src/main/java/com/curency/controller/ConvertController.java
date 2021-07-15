package com.curency.controller;

import com.curency.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @Autowired
    CalculateService calculateService;

    @PostMapping(value = "/convert")
    public ModelAndView convert(@RequestParam String usd, String exchangeRate) {

        try {
            double usdMoney = Double.parseDouble(usd);
            double exchangeRateNum = Double.parseDouble(exchangeRate);
            double result = calculateService.calculateConvert(usdMoney, exchangeRateNum);
            return new ModelAndView("index", "result", result);
        } catch (NumberFormatException e) {
            return new ModelAndView("index", "exception", "Mời nhập chữ số");
        }
    }

    @RequestMapping(value = "")
    public String home() {
        return "index";
    }
}
