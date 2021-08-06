package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.entity.Customer;
import com.codegym.model.service.CustomerService;
import com.codegym.model.service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping(value = "/list")
    public ModelAndView showCustomerList(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword
            , ModelMap modelMap) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        modelMap.addAttribute("keywordValue", keywordValue);

        return new ModelAndView("/customer/list", "customerList", customerService.findAllByName(pageable, keywordValue));
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(ModelMap modelMap) {
        modelMap.addAttribute("customerDto", new CustomerDto());
        modelMap.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("customerDto", customerDto);
            modelMap.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "create new customer successfully");
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping(value = "/delete")
    public String reomveCustomer(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {

        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()) {
          Customer customer =  customerOptional.get();
          customer.setFlags(0);
          customerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "delete customer successfully");
            return "redirect:/customer/list";
        }
        redirectAttributes.addFlashAttribute("success", "delete customer unsuccessful");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, ModelMap modelMap) {
        Optional<Customer> customerOptional = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        if (customerOptional.isPresent()) {
            BeanUtils.copyProperties(customerOptional.get(), customerDto);
            modelMap.addAttribute("customerDto", customerDto);
            modelMap.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/edit";
        }
        return "redirect:/customer/list";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("customerDto", customerDto);
            modelMap.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        redirectAttributes.addFlashAttribute("success", "update customer successfully");
        customerService.save(customer);
        return "redirect:/customer/list";
    }

}
