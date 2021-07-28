package com.codegym.controller;

import com.codegym.model.dto.CartDto;
import com.codegym.model.dto.ProductDto;
import com.codegym.model.entity.Oder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false)CartDto cart, Model model){
        Map<ProductDto,Integer> mapCart =cart.getProductDtoMap();
       model.addAttribute("oder",new Oder());
        return new ModelAndView("cart/list","mapCart",mapCart);
    }
    @GetMapping("/{id}")
    public ModelAndView deleteCart(@SessionAttribute(value = "cart",required = false)CartDto cart, Model model, @PathVariable Long id){
        ProductDto productDto = cart.findProductDtoById(id);
        cart.removeProductDtoMap(productDto);
        Map<ProductDto,Integer> mapCart = cart.getProductDtoMap();
        model.addAttribute("oder",new Oder());
        return new ModelAndView("cart/list","mapCart",mapCart);
    }

}
