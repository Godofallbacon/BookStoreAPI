package com.SimpleBookStore.BookStore.repository;

import com.SimpleBookStore.BookStore.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> getByCategoryId(long categoryId);

    @Query(value = "Select * From book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Iterable<Book>  searchBooks(String query);
}
