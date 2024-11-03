package com.example.bookcatalog.BookService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookcatalog.Book.Book;
import com.example.bookcatalog.BookRepository.BookRepository;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        logger.info("Fetching all books from the repository");
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        logger.info("Fetching book with id: {} from the repository", id);
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book){
        logger.info("Saving book: {} to the repository", book);
        return bookRepository.save(book);
    }
    public void delete(Long id){
        logger.info("Deleting book with id: {} from the repository", id);
        bookRepository.deleteById(id);
    }


}
