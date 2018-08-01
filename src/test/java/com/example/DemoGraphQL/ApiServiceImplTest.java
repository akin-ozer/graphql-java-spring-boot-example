package com.example.DemoGraphQL;

import com.example.DemoGraphQL.model.implementations.Author;
import com.example.DemoGraphQL.model.implementations.Book;
import com.example.DemoGraphQL.model.implementations.FindAllBook;
import com.example.DemoGraphQL.services.ApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetUsers() throws Exception{
        List<Book> books = apiService.getBooks("3");
        assertEquals(2, books.size());
    }

    @Test
    public void testGetAuthors() throws Exception{
        List<Author> authors = apiService.getAuthors("2");
        assertEquals(1, authors.size());
    }

    @Test
    public void testNull() throws Exception{
        Author author = new Author();
        author.setFirstName("akin");
        int counter = 0;
        for (Field f: author.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if (f.get(author)!=null){
                counter++;
            }
        }
        assertEquals(counter, 1);
    }
}
