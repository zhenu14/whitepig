package com.designpattern.demo.prototype.example1;

import lombok.Data;

@Data
public class GouClone implements Cloneable{

    private int legCounts;

    Dog dog = new Dog(4);

    @Override
    protected GouClone clone() throws CloneNotSupportedException{
        return (GouClone) super.clone();
    }

}
