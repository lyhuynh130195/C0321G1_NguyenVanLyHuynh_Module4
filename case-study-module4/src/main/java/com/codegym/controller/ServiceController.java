package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.dto.ServiceDto;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Service;
import com.codegym.model.service.RentTypeService;
import com.codegym.model.service.ServiceService;
import com.codegym.model.service.ServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping(value = "/create")
    public String showCreateForm(ModelMap modelMap){
        modelMap.addAttribute("serviceDto",new ServiceDto());
        modelMap.addAttribute("serviceTypeList",serviceTypeService.findAll());
        modelMap.addAttribute("rentTypeList",rentTypeService.findAll());
        return "/service/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("serviceDto", serviceDto);
            modelMap.addAttribute("serviceTypeList",serviceTypeService.findAll());
            modelMap.addAttribute("rentTypeList",rentTypeService.findAll());
            return "/service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "create new service successfully");
        serviceService.save(service);
        return "redirect:/home";
    }
}
