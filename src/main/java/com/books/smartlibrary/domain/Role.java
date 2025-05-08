package com.books.smartlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String roleId;
    private String admin;
    private String maxSimLoans;
    private String maxExpLoans;
}
