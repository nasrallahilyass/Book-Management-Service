package com.example.java.service.book;

import com.example.java.exceptions.NotFoundException;
import com.example.java.model.Book;
import com.example.java.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    /*
       The @RequiredArgsConstructor annotation is provided by Lombok.
       It automatically generates a constructor for the class with parameters for
       all fields that are marked as final or are @NonNull.

       This means that Lombok will create a constructor that will initialize
       the productRepository field, which is required for the class to work properly.

       The final keyword is used to ensure that the field can only be assigned once,
       typically in the constructor, and its value cannot be changed later in the code.
       This helps enforce immutability for the field, making sure that the
       productRepository is properly initialized when the ProductService object is created.
   */
    private final BookRepository bookRepository;


    /*
        Get Books:
        - Get all books
        - Get book by id
        - Get book by title
        - Get book by author
        - Get book by category name
        - Get book by author and title
        - Get book by category name and author
        - Count book by author and title
        Count Books:
        - Count book by author and title

     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Book getBookByAuthorAndTitle(String author, String title) {
        return bookRepository.findByAuthorAndTitle(author, title);
    }

    @Override
    public Long countBookByAuthor(String author) {
        return bookRepository.countAllByAuthor(author);
    }


    /*
        CRUD Operations:
        - Add book
        - Update book
        - Delete book by id
     */

    @Override
    public Book addBook(Book book) {
        Book newBook = createBook(book);
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateBook(Book book, String id) {
        return bookRepository.findById(id)
                .map(existingProduct -> bookRepository.save(updateExistingBook(existingProduct, book)))
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.findById(id).
                ifPresentOrElse(bookRepository::delete,
                        () -> {
                            throw new NotFoundException("Book not found");
                        });
    }

    // Helper methods
    // Create a new book object
    public Book createBook(Book book) {
        return new Book(
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getPrice(),
                book.getCategory()
        );
    }

    // Update an existing book object
    public Book updateExistingBook(Book existingBook, Book book) {
        existingBook.setIsbn(book.getIsbn());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        return existingBook;
    }
}