package com.codegym.controller;

import com.codegym.model.dto.ContractDetailDto;
import com.codegym.model.entity.ContractDetail;
import com.codegym.model.service.AttachServiceService;
import com.codegym.model.service.ContractDetailService;
import com.codegym.model.service.ContractService;
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
@RequestMapping(value = "/contract_detail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;

    @RequestMapping("/list")
    public ModelAndView showListContractDetail(@PageableDefault(value = 3) Pageable pageable,@RequestParam(required=false,name="keyword") Optional<String> keyword) {
        if(!keyword.isPresent()){
            return new ModelAndView("/contract_detail/list", "contractDetailList",contractDetailService.findAll(pageable));
        }
        return new ModelAndView("/contract_detail/list", "contractDetailList",contractDetailService.findAllByDate(pageable,Integer.parseInt(keyword.get())));
    }

    @GetMapping(value = "/create")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("listAttachService", attachServiceService.findAll());
        modelMap.addAttribute("listContract", contractService.findAll());
        modelMap.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contract_detail/create";
    }

    @PostMapping(value = "/save")
    public String saveContract(@Validated @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult, ModelMap modelMap,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("contractDetailDto", contractDetailDto);
            modelMap.addAttribute("listAttachService", attachServiceService.findAll());
            modelMap.addAttribute("listContract", contractService.findAll());
            return "/contract_detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetail.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "Create new contractDetail successfully");
        contractDetailService.save(contractDetail);
        return "redirect:/contract_detail/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, ModelMap modelMap) {
        Optional<ContractDetail> contractDetailOptional = contractDetailService.findById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        if (contractDetailOptional.isPresent()) {
            BeanUtils.copyProperties(contractDetailOptional.get(), contractDetailDto);
            modelMap.addAttribute("contractDetailDto", contractDetailDto);
            modelMap.addAttribute("listAttachService", attachServiceService.findAll());
            modelMap.addAttribute("listContract", contractService.findAll());
            return "/contract_detail/edit";
        }
        return "redirect:/contract_detail/list";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("contractDetailDto", contractDetailDto);
            modelMap.addAttribute("listAttachService", attachServiceService.findAll());
            modelMap.addAttribute("listContract", contractService.findAll());
            return "/contract_detail/edit";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetail.setFlags(1);
        redirectAttributes.addFlashAttribute("success", "Update contractDetail successfully");
        contractDetailService.save(contractDetail);
        return "redirect:/contract_detail/list";
    }

    @PostMapping(value = "/delete")
    public String removeContractDetail(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {

        Optional<ContractDetail> contractDetailOptional = contractDetailService.findById(id);

        if (contractDetailOptional.isPresent()) {
            ContractDetail contractDetail =  contractDetailOptional.get();
            contractDetail.setFlags(0);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("success", "Delete contractDetail successfully");
            return "redirect:/contract_detail/list";
        }
        redirectAttributes.addFlashAttribute("success", "Delete contractDetail unsuccessful");
        return "redirect:/contract_detail/list";
    }

}
