package com.SimpleBookStore.BookStore.repository;


import com.SimpleBookStore.BookStore.model.Book;
import com.SimpleBookStore.BookStore.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
