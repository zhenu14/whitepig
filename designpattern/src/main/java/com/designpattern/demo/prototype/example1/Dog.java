package com.designpattern.demo.prototype.example1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Dog implements  Cloneable{

    private int legCounts;

    public void changeLegCounts(){
        this.legCounts *= 2;
    }

    @Override
    public Dog clone() throws CloneNotSupportedException{
        return (Dog) super.clone();
    }

}
