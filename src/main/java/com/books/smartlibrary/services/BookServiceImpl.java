package com.books.smartlibrary.services;

import com.books.smartlibrary.domain.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "1234567890123"),
            new Book(2, "5554567890123"),
            new Book(3, "6664567890123")
    ));

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
