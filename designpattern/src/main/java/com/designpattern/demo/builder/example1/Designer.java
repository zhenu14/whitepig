package com.designpattern.demo.builder.example1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Designer {
    public void order(Builder builder){
        builder.makeFloor();
        builder.makeWindow();
    }
}
