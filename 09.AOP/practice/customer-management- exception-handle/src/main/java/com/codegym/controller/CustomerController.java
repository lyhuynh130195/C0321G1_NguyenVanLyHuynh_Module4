package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Province;
import com.codegym.model.service.CustomerService;
import com.codegym.model.service.ProvinceService;
import com.codegym.model.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    ProvinceService provinceService;
    @Autowired
    CustomerService customerService;

    @ModelAttribute("provinces")
    public List<Province> allProvinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }

    private Page<Customer> getPage(Pageable pageInfo) {
        return customerService.findAll(pageInfo);
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        try {
            ModelAndView modelAndView = new ModelAndView("info");
            Optional<Customer> customerOptional = customerService.findOne(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) throws DuplicateEmailException{
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }


    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}
