package com.SimpleBookStore.BookStore.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Category {
    @NotNull
    @Column(unique = true)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", CategoryId=" + id +
                '}';
    }
}
