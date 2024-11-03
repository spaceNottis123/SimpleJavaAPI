package com.example.bookcatalog.BookController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookcatalog.Book.Book;
import com.example.bookcatalog.BookService.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookservice;

    @GetMapping
    public List<Book> getAllBooks(){
        logger.info("Received request to get all books");
        return bookservice.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        logger.info("Received request to get book by id: {}", id);
        Book book = bookservice.findById(id);
        if (book != null){
            logger.info("Book found with id: {}", id);
            return ResponseEntity.ok(book);
        }else{
            logger.warn("Book not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book){
        logger.info("Received request to create a book: {}", book);
        return bookservice.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
        logger.info("Received request to update book with id: {}", id);
        Book book = bookservice.findById(id);
        if (book == null){
            logger.warn("Book not found with id: {}", id);
            return  ResponseEntity.notFound().build();
        }
        
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());
        logger.info("Updating book with id: {}", id);
        return ResponseEntity.ok(bookservice.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        logger.info("Received request to delete book with id: {}", id);
        if(bookservice.findById(id) == null) {
            logger.warn("Book not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
        bookservice.delete(id);
        logger.info("Deleted book with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
