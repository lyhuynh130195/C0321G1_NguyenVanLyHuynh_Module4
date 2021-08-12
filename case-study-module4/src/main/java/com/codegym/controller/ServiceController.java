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
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping(value = "/list")
    public ModelAndView showServiceList(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword
            , ModelMap modelMap) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        modelMap.addAttribute("keywordValue", keywordValue);

        return new ModelAndView("/service/list", "serviceList", serviceService.findAllByName(pageable, keywordValue));
    }

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
        redirectAttributes.addFlashAttribute("success", "Create new service successfully");
        serviceService.save(service);
        return "redirect:/service/list";
    }

    @PostMapping(value = "/delete")
    public String removeService(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {

        Optional<Service> serviceOptional = serviceService.findById(id);

        if (serviceOptional.isPresent()) {
            Service service =  serviceOptional.get();
            service.setFlags(0);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("success", "Delete service successfully");
            return "redirect:/service/list";
        }
        redirectAttributes.addFlashAttribute("success", "Delete service unsuccessful");
        return "redirect:/service/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, ModelMap modelMap) {
        Optional<Service> serviceOptional = serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        if (serviceOptional.isPresent()) {
            BeanUtils.copyProperties(serviceOptional.get(), serviceDto);
            modelMap.addAttribute("serviceDto", serviceDto);
            modelMap.addAttribute("serviceTypeList",serviceTypeService.findAll());
            modelMap.addAttribute("rentTypeList",rentTypeService.findAll());
            return "/service/edit";
        }
        return "redirect:/service/list";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("serviceDto", serviceDto);
            modelMap.addAttribute("serviceTypeList",serviceTypeService.findAll());
            modelMap.addAttribute("rentTypeList",rentTypeService.findAll());
            return "/service/edit";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "Update service successfully");
        serviceService.save(service);
        return "redirect:/service/list";
    }

}
