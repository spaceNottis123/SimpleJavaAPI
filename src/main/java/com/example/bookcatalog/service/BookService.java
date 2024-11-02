package com.example.bookcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.repository.BookRepository;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
            return bookRepository.findAll();
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }
    public void delete(Long id){
        bookRepository.deleteById(id);
    }


}
