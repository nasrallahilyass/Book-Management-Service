package com.example.java.service.book;

import com.example.java.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    Book getBookById(String id);

    Book getBookByTitle(String title);

    Book getBookByAuthor(String author);

    Book getBookByAuthorAndTitle(String author, String title);

    Long countBookByAuthor(String author);


    Book addBook(Book book);

    Book updateBook(Book book, String id);

    void deleteBookById(String id);
}
