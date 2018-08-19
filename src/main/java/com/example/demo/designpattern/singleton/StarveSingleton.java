package com.example.demo.designpattern.singleton;

public class StarveSingleton {

    private static StarveSingleton instance = new StarveSingleton();

    private StarveSingleton(){

    }

    public static StarveSingleton getInstance(){
        return instance;
    }

}
