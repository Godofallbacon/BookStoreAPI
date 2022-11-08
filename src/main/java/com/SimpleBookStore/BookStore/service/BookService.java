package com.SimpleBookStore.BookStore.service;

import com.SimpleBookStore.BookStore.model.Book;
import com.SimpleBookStore.BookStore.repository.BookRepository;
import com.SimpleBookStore.BookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createBook(Long categoryId, Book book){
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category.getCategory());
            return bookRepository.save(book);
        });
    }
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public ResponseEntity<?> getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    public void updateBookById(Long categoryId, Book book) {
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category.getCategory());
            return bookRepository.save(book);
        });
    }
    public void deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
    public Iterable<Book> getByCategoryId(Long categoryId){
        return bookRepository.getByCategoryId(categoryId);
    }
    public Iterable<Book> findBookByName(String query){
        return bookRepository.searchBooks(query);
    }
}
