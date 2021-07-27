package com.codegym.model.service;

import com.codegym.model.entity.Book;
import com.codegym.model.repository.BookRepository;
import com.codegym.model.service.exception.AmountBookNotEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Book book) throws AmountBookNotEnough {
        int amount=book.getAmount();
        if(amount>=1){
            book.setAmount(amount-1);
            bookRepository.save(book);
        }else {
            throw new AmountBookNotEnough();
        }
    }

    @Override
    public void retrospectBook(Book book) {
        int amount=book.getAmount();
        book.setAmount(amount+1);
        bookRepository.save(book);
    }
}
