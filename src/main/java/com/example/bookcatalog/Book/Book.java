package com.example.bookcatalog.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private double price;

    // getters and setters
    public Book(){
        //Default constructor for JPA
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        logger.info("Setting id to {}", id);
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        logger.info("Setting title to '{}'", title);
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        logger.info("Setting author to '{}'", author);
        this.author = author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        logger.info("Setting genre to '{}'", genre);
        this.genre = genre;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        logger.info("Setting price to {}", price);
        this.price = price;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price +
                '}';
    }

}
