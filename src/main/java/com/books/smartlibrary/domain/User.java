package com.books.smartlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String id;
    private String lastname;
    private String email;
}
