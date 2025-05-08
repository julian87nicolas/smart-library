package com.books.smartlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookId;
    private String isnb;
    private String title;
    private String language;
    private String genre_id;
    private String digital;
    private String authorId;
    private String publisherId;
    private String inStock;
    private String year;
    private String version;
}
