package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
@Autowired
    private ProductService productService;

    @RequestMapping("")
    public String index(ModelMap model) {
        model.addAttribute("listProduct", productService.findAll());
        return "index";
    }

    @RequestMapping(value = "/create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Create product successfully");
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Update product successfully");
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Delete product successfully");
        productService.remove(product.getId());
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "view";
    }

    @PostMapping(value = "/search")
    public String searchByName(@RequestParam String name, ModelMap modelMap, RedirectAttributes redirect) {
        Product product = productService.findByName(name);
        if (product == null) {
            redirect.addFlashAttribute("notFind", "No products found");
            return "redirect:/product";
        }
        modelMap.addAttribute("product",product);
        return "view";
    }
}
