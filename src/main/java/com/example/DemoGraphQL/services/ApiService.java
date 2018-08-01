package com.example.DemoGraphQL.services;

import com.example.DemoGraphQL.model.implementations.Author;
import com.example.DemoGraphQL.model.implementations.Book;
import com.example.DemoGraphQL.model.implementations.FindAllBook;

import java.util.List;

public interface ApiService {
    List<Book> getBooks(String query);
    List<Author> getAuthors(String query);
}
