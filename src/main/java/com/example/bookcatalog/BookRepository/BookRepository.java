package com.example.bookcatalog.BookRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookcatalog.Book.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom queries (if needed) can be added here   
}
