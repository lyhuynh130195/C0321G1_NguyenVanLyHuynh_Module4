package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public String index(ModelMap model) {
        model.addAttribute("listProduct", productService.findAll());
        return "index";
    }

    @GetMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping(value = "/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Save product successfully");
        return "redirect:/products";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findOne(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Update product successfully");
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findOne(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Delete product successfully");
        productService.delete(product.getId());
        return "redirect:/products";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findOne(id));
        return "view";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam String name, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        Product product = productService.findByName(name);
        if (product != null) {
            modelMap.addAttribute("product", product);
            return "view";
        }
        redirectAttributes.addFlashAttribute("notFind", "No products found");
        return "redirect:/products";
    }
}
