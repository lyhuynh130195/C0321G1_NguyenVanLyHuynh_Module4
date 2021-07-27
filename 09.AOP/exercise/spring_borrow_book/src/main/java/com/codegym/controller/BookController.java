package com.codegym.controller;

import com.codegym.model.entity.Book;
import com.codegym.model.service.BookService;
import com.codegym.model.service.exception.AmountBookNotEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/list")
    public ModelAndView showList(){
        return new ModelAndView("list","listBook",bookService.findAll());
    }

    @GetMapping(value = "/details/{id}")
    public ModelAndView showDetails(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        Book book = bookService.findById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @GetMapping(value = "/borrow/{id}")
    public String borrow(@PathVariable int id, RedirectAttributes redirectAttributes) throws AmountBookNotEnough {
     bookService.borrowBook(bookService.findById(id));
     redirectAttributes.addFlashAttribute("success","borrow success");
     return "redirect:/book/list";
    }

    @RequestMapping(value = "/retrospect")
    public String retrospectBook(@RequestParam int id,RedirectAttributes redirectAttributes){
        Book book = bookService.findById(id);
        if(book==null){
            redirectAttributes.addFlashAttribute("notFind","Not find book with id = "+id);
            return "redirect:/book/list";
        }else {
            redirectAttributes.addFlashAttribute("success","Retrospect Book success");
            bookService.retrospectBook(book);
            return "redirect:/book/list";
        }
    }

    @ExceptionHandler(AmountBookNotEnough.class)
    public ModelAndView amountBookNotEnough(){
        return new ModelAndView("error");
    }
}
