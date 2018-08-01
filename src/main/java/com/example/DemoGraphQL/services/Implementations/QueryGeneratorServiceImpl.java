package com.example.DemoGraphQL.services.Implementations;

import com.example.DemoGraphQL.model.formhelpers.FormField;
import com.example.DemoGraphQL.model.implementations.Author;
import com.example.DemoGraphQL.services.QueryGeneratorService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class QueryGeneratorServiceImpl implements QueryGeneratorService {

    @Override
    public String authorQuery(Author author) throws IllegalAccessException {
        String query;
        query = "{\n" +
                "  findAllAuthors {\n";

        for (Field f: author.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if (f.get(author)!=null){
                query = query + "    " +f.getName() + "\n";
            }
        }
        query += "  }\n" +
                "}";

        return query;
    }

    @Override
    public String fieldBasedQuery(List<String> formFields){
        String query;
        query = "{\n" +
                "  findAllAuthors {\n";

        for (String formField : formFields){
            query = query + "    " +formField + "\n";
        }
        query += "  }\n" +
                "}";

        return query;
    }
}
