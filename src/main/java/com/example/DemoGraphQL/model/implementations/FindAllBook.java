package com.example.DemoGraphQL.model.implementations;

import java.util.List;

public class FindAllBook {
    private List<Book> findAllBook;

    public List<Book> getFindAllBooks() {
        return findAllBook;
    }

    public void setFindAllBooks(List<Book> findAllBooks) {
        this.findAllBook = findAllBooks;
    }
}
