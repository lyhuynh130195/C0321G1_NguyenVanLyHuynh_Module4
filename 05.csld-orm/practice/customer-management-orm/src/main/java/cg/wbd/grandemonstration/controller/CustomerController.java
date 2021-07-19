package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public ModelAndView create(){
        return new ModelAndView("customers/create","customer",new Customer());
    }

    @PostMapping(value = "/save")
    public String updateCustomer(Customer customer,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Save customer successfully");
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable long id){
     return new ModelAndView("customers/delete","customer",customerService.findOne(id));
    }
    @PostMapping(value = "/delete")
    public String delete(Customer customer,RedirectAttributes redirectAttributes){
        customerService.delete(customer);
        redirectAttributes.addFlashAttribute("success", "Delete customer successfully");
        return "redirect:/customers";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable long id,ModelMap modelMap){
        modelMap.addAttribute("customer",customerService.findOne(id));
        return "customers/edit";
    }
    @PostMapping(value = "/update")
    public String update(Customer customer,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success", "Update customer successfully");
        customerService.update(customer);
        return "redirect:/customers";
    }

}
