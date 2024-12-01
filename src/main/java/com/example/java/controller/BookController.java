package com.example.java.controller;

import com.example.java.model.Book;
import com.example.java.response.ApiResponse;
import com.example.java.service.book.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.version}/books")

public class BookController {
    private final IBookService bookService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.ok(new ApiResponse("Books fetched successfully ✅", books));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<ApiResponse> getBookById(@PathVariable String id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(new ApiResponse("Book fetched successfully ✅", book));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/book/title/{title}")
    public ResponseEntity<ApiResponse> getBookByTitle(@PathVariable String title) {
        try {
            Book book = bookService.getBookByTitle(title);
            return ResponseEntity.ok(new ApiResponse("Book fetched successfully ✅", book));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/book/author/{author}")
    public ResponseEntity<ApiResponse> getBookByAuthor(@PathVariable String author) {
        try {
            Book book = bookService.getBookByAuthor(author);
            return ResponseEntity.ok(new ApiResponse("Book fetched successfully ✅", book));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/book/author/{author}/title/{title}")
    public ResponseEntity<ApiResponse> getBookByAuthorAndTitle(@PathVariable String author, @PathVariable String title) {
        try {
            Book book = bookService.getBookByAuthorAndTitle(author, title);
            return ResponseEntity.ok(new ApiResponse("Book fetched successfully ✅", book));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/book/count/author/{author}")
    public ResponseEntity<ApiResponse> countAllByAuthor(@PathVariable String author) {
        try {
            Long count = bookService.countBookByAuthor(author);
            return ResponseEntity.ok(new ApiResponse("Book fetched successfully ✅", count));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addBook(@RequestBody Book book) {
        try {
            Book newBook = bookService.addBook(book);
            return ResponseEntity.ok(new ApiResponse("Book added successfully ✅", newBook));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateBook(@RequestBody Book book, @PathVariable String id) {
        try {
            Book updatedBook = bookService.updateBook(book, id);
            return ResponseEntity.ok(new ApiResponse("Book updated successfully ✅", updatedBook));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteBookById(@PathVariable String id) {
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.ok(new ApiResponse("Book deleted successfully ✅", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
