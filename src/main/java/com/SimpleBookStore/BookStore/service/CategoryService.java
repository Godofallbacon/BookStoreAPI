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

    //public void verifyCategory(Long categoryId) {
        //Category category = categoryRepository.findById(categoryId).orElse(null).getCategory();
    //}

    public ResponseEntity<?> getCategory(Long CategoryId) {
        Optional<Category> c = categoryRepository.findById(CategoryId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }

    public void createCategory(Category category) {
        category=categoryRepository.save(category);
    }


    public void updateCategory(Category category, Long CategoryId) {
        categoryRepository.save(category);
    }

    public ResponseEntity<?> deleteCategory(Long CategoryId) {
        categoryRepository.deleteById(CategoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        Iterable<Category> allCategory = categoryRepository.findAll();
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
