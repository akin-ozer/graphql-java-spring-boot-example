package com.example.DemoGraphQL.controllers;

import com.example.DemoGraphQL.model.formhelpers.CheckboxData;
import com.example.DemoGraphQL.model.formhelpers.FormField;
import com.example.DemoGraphQL.model.implementations.Author;
import com.example.DemoGraphQL.services.ApiService;
import com.example.DemoGraphQL.services.QueryGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    private QueryGeneratorService queryGeneratorService;
    private ApiService apiService;

    @Autowired
    public IndexController(QueryGeneratorService queryGeneratorService, ApiService apiService) {
        this.queryGeneratorService = queryGeneratorService;
        this.apiService = apiService;
    }

    @GetMapping({"/", "", "/index"})
    public String getIndex(Model model){
        model.addAttribute("authorImpl", new Author());
        return "index";
    }

    @PostMapping("/index")
    public String set(@ModelAttribute Author author, Model model) throws IllegalAccessException {
        String query = queryGeneratorService.authorQuery(author);
        model.addAttribute("authorList", apiService.getAuthors(query));
        return "/result";
    }

    @GetMapping("/result")
    public String getResult(){
        return "result";
    }

    @GetMapping("/checkbox")
    public String getCheckbox(Model model){
        Author author = new Author();
        FormField formField;
        List<FormField> fieldList = new ArrayList<>();
        for (Field f: author.getClass().getDeclaredFields()){
            f.setAccessible(true);
            formField = new FormField();
            formField.setName(f.getName());
            fieldList.add(formField);
        }
        model.addAttribute("fields", fieldList);
        model.addAttribute("checkboxdata", new CheckboxData());
        return "checkbox";
    }

    @PostMapping("/checkbox")
    public String postCheckbox(@ModelAttribute CheckboxData checkboxData, Model model) throws IllegalAccessException {
        String query = queryGeneratorService.fieldBasedQuery(checkboxData.getFormFields());
        model.addAttribute("checkBoxAuthorList", apiService.getAuthors(query));
        return "/checkboxresult";
    }

    @GetMapping("/checkboxresult")
    public String getCheckboxResult(){
        return "checkboxresult";
    }




}
