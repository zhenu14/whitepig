package com.example.demo.designpattern.builder.example1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Designer {
    public void order(Builder builder){
        builder.makeFloor();
        builder.makeWindow();
    }
}
