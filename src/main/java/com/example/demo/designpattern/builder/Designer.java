package com.example.demo.designpattern.builder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Designer {
    public void order(Builder builder){
        builder.makeFloor();
        builder.makeWindow();
    }
}
