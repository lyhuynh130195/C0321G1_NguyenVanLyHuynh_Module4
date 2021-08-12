package com.codegym.controller;

import com.codegym.model.dto.ContractDto;
import com.codegym.model.entity.Contract;
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
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    ContractService contractService;
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping("/list")
    public ModelAndView showListContract(@PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> keyword
            , ModelMap modelMap) {
        String keywordValue = "";

        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        modelMap.addAttribute("keywordValue", keywordValue);
        return new ModelAndView("/contract/list", "contractList", contractService.findAllByDate(pageable, keywordValue));
    }

    @GetMapping(value = "/create_contract")
    public String showCreateContract(ModelMap modelMap){
        modelMap.addAttribute("contractDto",new ContractDto());
        modelMap.addAttribute("customerList",customerService.findAll());
        modelMap.addAttribute("employeeList",employeeService.findAll());
        modelMap.addAttribute("serviceList",serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping(value = "/save")
    public String saveContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, ModelMap modelMap,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            modelMap.addAttribute("contractDto",contractDto);
            modelMap.addAttribute("customerList",customerService.findAll());
            modelMap.addAttribute("employeeList",employeeService.findAll());
            modelMap.addAttribute("serviceList",serviceService.findAll());
            return "/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setFlags(1);
        double costService =  contract.getService().getCost();
        double costRent = rentTypeService.findById(contract.getService().getRentType().getId()).get().getCost();
        double totalCost = costRent+costService;
        contract.setTotalMoney(totalCost);
        redirectAttributes.addFlashAttribute("success", "Create new contract successfully");
        contractService.save(contract);
        return "redirect:/contract/list";
    }

    @PostMapping(value = "/delete")
    public String removeContract(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {

        Optional<Contract> contractOptional = contractService.findById(id);

        if (contractOptional.isPresent()) {
            Contract contract =  contractOptional.get();
            contract.setFlags(0);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("success", "Delete contract successfully");
            return "redirect:/contract/list";
        }
        redirectAttributes.addFlashAttribute("success", "Delete contract unsuccessful");
        return "redirect:/contract/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, ModelMap modelMap) {
        Optional<Contract> contractOptional = contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        if (contractOptional.isPresent()) {
            BeanUtils.copyProperties(contractOptional.get(), contractDto);
            modelMap.addAttribute("contractDto", contractDto);
            modelMap.addAttribute("contractDto",contractDto);
            modelMap.addAttribute("customerList",customerService.findAll());
            modelMap.addAttribute("employeeList",employeeService.findAll());
            modelMap.addAttribute("serviceList",serviceService.findAll());
            return "/contract/edit";
        }
        return "redirect:/contract/list";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("contractDto", contractDto);
            modelMap.addAttribute("customerList",customerService.findAll());
            modelMap.addAttribute("employeeList",employeeService.findAll());
            modelMap.addAttribute("serviceList",serviceService.findAll());
            return "/contract/edit";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contract.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "Update contract successfully");
        contractService.save(contract);
        return "redirect:/contract/list";
    }

}
