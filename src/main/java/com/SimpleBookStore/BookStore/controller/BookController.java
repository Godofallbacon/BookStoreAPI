package com.SimpleBookStore.BookStore.controller;

import com.SimpleBookStore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<com.SimpleBookStore.BookStore.domain.Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Book book){
        bookService.createBook(categoryId, book);
    }


    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBookById(@PathVariable Long categoryId, @RequestBody com.SimpleBookStore.BookStore.domain.Book book) {
        bookService.updateBookById(categoryId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/books/{categoryId/books")
    public Iterable<com.SimpleBookStore.BookStore.domain.Book> getByCategoryId(@PathVariable Long categoryId) {
        return bookService.getByCategoryId(categoryId);
    }

    @GetMapping("/searchBooks")
    public Iterable<com.SimpleBookStore.BookStore.domain.Book> searchBooks(@RequestParam("query") String query) {
        return bookService.findBookByName(query);
    }
}
