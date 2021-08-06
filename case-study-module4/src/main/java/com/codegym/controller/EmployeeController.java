package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.dto.EmployeeDto;
import com.codegym.model.entity.AppUser;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import com.codegym.model.service.*;
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
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    EducationService educationService;

    @GetMapping(value = "/list")
    public ModelAndView showEmployeeList(@PageableDefault Pageable pageable, @RequestParam Optional<String> keyword,
                                         ModelMap modelMap) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        modelMap.addAttribute("keywordValue", keywordValue);

        return new ModelAndView("/employee/list", "employeeList", employeeService.findAllByName(pageable, keywordValue));
    }

    @GetMapping(value = "/create")
    public String showCreateEmployee(ModelMap modelMap) {
        modelMap.addAttribute("employeeDto", new EmployeeDto());
        modelMap.addAttribute("positionList", positionService.findAll());
        modelMap.addAttribute("divisionList", divisionService.findAll());
        modelMap.addAttribute("educationList", educationService.findAll());
        modelMap.addAttribute("appUserList", appUserService.findAll());
        return "/employee/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("employeeDto", employeeDto);
            modelMap.addAttribute("positionList", positionService.findAll());
            modelMap.addAttribute("divisionList", divisionService.findAll());
            modelMap.addAttribute("educationList", educationService.findAll());
            modelMap.addAttribute("appUserList", appUserService.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "create new employee successfully");
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @PostMapping(value = "/delete")
    public String reomveCustomer(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {

        Optional<Employee> employeeOptional = employeeService.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFlags(0);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("success", "delete employee successfully");
            return "redirect:/employee/list";
        }
        redirectAttributes.addFlashAttribute("success", "delete employee unsuccessful");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, ModelMap modelMap) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        if (employeeOptional.isPresent()) {
            BeanUtils.copyProperties(employeeOptional.get(), employeeDto);
            modelMap.addAttribute("employeeDto", employeeDto);
            modelMap.addAttribute("positionList", positionService.findAll());
            modelMap.addAttribute("divisionList", divisionService.findAll());
            modelMap.addAttribute("educationList", educationService.findAll());
            modelMap.addAttribute("appUserList", appUserService.findAll());
            return "/employee/edit";
        }
        return "redirect:/employee/list";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("employeeDto", employeeDto);
            modelMap.addAttribute("positionList", positionService.findAll());
            modelMap.addAttribute("divisionList", divisionService.findAll());
            modelMap.addAttribute("educationList", educationService.findAll());
            modelMap.addAttribute("appUserList", appUserService.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        redirectAttributes.addFlashAttribute("success", "update employee successfully");
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/{id}/view")
    public String showViewEmployee(@PathVariable int id,ModelMap modelMap) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            modelMap.addAttribute("employee",employee);
            return "/employee/view";
        }
        return "redirect:/employee/list";
    }
}
