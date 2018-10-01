package com.feature.demo.chapter4.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Dish {
    private String name;
    private boolean vegatarian;
    private int calories;
    Type type;

    public
    enum Type{
        MEAT,FISH,OTHER
    }
}
