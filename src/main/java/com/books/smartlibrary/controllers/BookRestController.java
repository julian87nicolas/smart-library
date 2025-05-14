package com.books.smartlibrary.controllers;

import com.books.smartlibrary.services.BookService;
import com.books.smartlibrary.services.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private BookService bookService = new BookServiceImpl();

    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }
}
