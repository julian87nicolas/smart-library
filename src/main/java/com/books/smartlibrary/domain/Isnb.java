package com.books.smartlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Isnb {
    public String isnbId;
    public Integer numberOrders;
    public Long totalScores;
    public Long numberScores;
    public boolean digitalVersion;
}
