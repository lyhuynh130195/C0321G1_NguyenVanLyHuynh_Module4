package com.codegym.model.service;

import com.codegym.model.entity.Book;
import com.codegym.model.service.exception.AmountBookNotEnough;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    void remove(Book book);

    Book findById(int id);

    void borrowBook(Book book) throws AmountBookNotEnough;

    void retrospectBook(Book book);

}
