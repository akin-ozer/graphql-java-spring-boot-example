package com.example.DemoGraphQL.services.Implementations;

import com.example.DemoGraphQL.model.implementations.*;
import com.example.DemoGraphQL.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    public static final String URL= "http://localhost:8080/graphql?query={query}";

    RestTemplate restTemplate;

    @Autowired
    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Book> getBooks(String query) {
        if (query==null) {
            query = "{\n" +
                    "  findAllBooks {\n" +
                    "    id\n" +
                    "    isbn\n" +
                    "    title\n" +
                    "    pageCount\n" +
                    "    author {\n" +
                    "      id\n" +
                    "      firstName\n" +
                    "      lastName\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        BookData bookData = restTemplate.getForObject(URL, BookData.class, query);
        return bookData.getData().getFindAllBooks();
    }


    @Override
    public List<Author> getAuthors(String query){
        if (query==null) {
            query = "{\n" +
                    "  findAllAuthors {\n" +
                    "    id\n" +
                    "    firstName\n" +
                    "    lastName\n" +
                    "  }\n" +
                    "}";
        }
        AuthorData authorData = restTemplate.getForObject(URL , AuthorData.class, query);
        return authorData.getData().getFindAllAuthors();
    }
}
