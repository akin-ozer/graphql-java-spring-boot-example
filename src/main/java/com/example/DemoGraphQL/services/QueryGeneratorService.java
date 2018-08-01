package com.example.DemoGraphQL.services;

import com.example.DemoGraphQL.model.formhelpers.FormField;
import com.example.DemoGraphQL.model.implementations.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueryGeneratorService {
    /**
     * @param author
     * @return
     * @throws IllegalAccessException
     *
     * This method creates GraphQL query type JSON
     * JSON creation is backed by reflection api, so it is dynamic
     * Map Type class variables will interfere this(Using json ignore won't work)because they are passing null test even if they are null
     */
    String authorQuery(Author author) throws IllegalAccessException;
    String fieldBasedQuery(List<String> formFields);
}
