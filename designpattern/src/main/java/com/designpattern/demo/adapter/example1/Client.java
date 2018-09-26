package com.designpattern.demo.adapter.example1;

public class Client {
    public static void main(String[] a){
        Target target = new Adapter();
        target.provice25();
    }
}
