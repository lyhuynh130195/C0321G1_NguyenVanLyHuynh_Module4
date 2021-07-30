package com.codegym.controller;

import com.codegym.model.dto.CartDto;
import com.codegym.model.dto.ProductDto;
import com.codegym.model.entity.Oder;
import com.codegym.model.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/oder")
public class OderController {

    @Autowired
    OderService oderService;

    @GetMapping(value = "/{id}")
    public String saveCart(@ModelAttribute Oder oder, @SessionAttribute(value = "cart", required = false) CartDto cart,
                           RedirectAttributes redirectAttributes, @PathVariable Long id) {
        oderService.save(oder);
        ProductDto productDto = cart.findProductDtoById(id);
        cart.removeProductDtoMap(productDto);
        redirectAttributes.addFlashAttribute("success", "Thanh toán thành công");
        return "redirect:/shop";
    }
}
