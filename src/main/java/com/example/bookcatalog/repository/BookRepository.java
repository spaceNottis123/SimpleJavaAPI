package com.example.bookcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookcatalog.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom queries (if needed) can be added here   
}
