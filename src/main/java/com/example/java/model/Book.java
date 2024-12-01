package com.example.java.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")

public class Book {
    @Id
    private String id;
    private String isbn;
    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private String category;


    public Book(String isbn, String title, String author, String description, BigDecimal price, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
