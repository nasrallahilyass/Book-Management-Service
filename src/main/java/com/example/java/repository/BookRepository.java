package com.example.java.repository;


import com.example.java.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
    Repository Layer:
    *It's a bridge between the service layer and the data store.*
    The repository layer is responsible for handling data access and persistence.
    It provides an abstraction over the underlying data store,
    allowing the service layer to interact with the data store
    without having to deal with the details of the data store implementation.

 */
public interface BookRepository extends MongoRepository<Book, String> {
    // queries methods
    <List> Book findByTitle(String title);

    <List> Book findByAuthor(String author);

    <List> Book findByAuthorAndTitle(String author, String title);

    Long countAllByAuthor(String author);

}
