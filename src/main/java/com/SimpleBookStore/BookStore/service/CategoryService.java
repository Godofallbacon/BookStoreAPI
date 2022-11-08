package com.SimpleBookStore.BookStore.service;

import com.SimpleBookStore.BookStore.model.Book;
import com.SimpleBookStore.BookStore.model.Category;
import com.SimpleBookStore.BookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void verifyCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null).getCategory();
    }

    public ResponseEntity<?> getCategory(Long CategoryId) {
        Optional<Book> c = categoryRepository.findById(CategoryId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }

    public ResponseEntity<?> createCategory(Category category) {
        category=categoryRepository.save(category);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCategoryUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        responseHeaders.setLocation(newCategoryUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    public void updateCategory(Category category, Long CategoryId) {
        categoryRepository.save(category);
    }

    public ResponseEntity<?> deleteCategory(Long CategoryId) {
        categoryRepository.deleteById(CategoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        Iterable<Book> allCategory = categoryRepository.findAll();
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
