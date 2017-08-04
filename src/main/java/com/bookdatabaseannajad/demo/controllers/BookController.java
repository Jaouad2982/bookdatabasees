package com.bookdatabaseannajad.demo.controllers;
import com.bookdatabaseannajad.demo.models.Book;
import com.bookdatabaseannajad.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String getPage(Model model){
        String theMessage = "Welcome to my page";
        model.addAttribute("message" , theMessage);
        return "page";
    }

    @GetMapping("/addBook")
    public String addInform(Model model ){
        model.addAttribute("newBook" , new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String showResult(@Valid @ModelAttribute("newBook") Book book, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
            return "addBook";

        }
        bookRepository.save(book);
        return "result";
    }


}
