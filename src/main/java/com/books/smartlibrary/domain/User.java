package com.books.smartlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String userId;
    private String id;
    private String name;
    private String lastName;
    private String gender;
    private String roleId;
}
