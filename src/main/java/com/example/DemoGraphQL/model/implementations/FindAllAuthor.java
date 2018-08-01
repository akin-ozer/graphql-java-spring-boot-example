package com.example.DemoGraphQL.model.implementations;

import java.util.List;

public class FindAllAuthor {
    private List<Author> findAllAuthor;

    public List<Author> getFindAllAuthors() {
        return findAllAuthor;
    }

    public void setFindAllAuthors(List<Author> findAllAuthors) {
        this.findAllAuthor = findAllAuthors;
    }
}
