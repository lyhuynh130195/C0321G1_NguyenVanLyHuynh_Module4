package com.codegym.controller;

import com.codegym.model.dto.CartDto;
import com.codegym.model.dto.ProductDto;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public CartDto initSession() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showList() {

        return new ModelAndView("product/list", "listProduct", productService.findALl());
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetailProduct(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error.404";
        }
        model.addAttribute("product", productOptional.get());
        return "product/view";
    }

    @GetMapping(value = "/add/{id}")
    public String addProduct(@PathVariable Long id, @SessionAttribute CartDto cart, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error.404";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(), productDto);
        cart.addProductDto(productDto);

        redirectAttributes.addFlashAttribute("success", "Thêm 1" +
                " " + productDto.getName() + " vào giỏ hàng thành công");
        return "redirect:/shop";

    }
}
