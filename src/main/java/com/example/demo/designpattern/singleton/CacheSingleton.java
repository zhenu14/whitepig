package com.example.demo.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;

public class CacheSingleton {

    private final static String DEFAULT_KEY = "One";

    private static Map<String,CacheSingleton> map = new HashMap<>();

    private CacheSingleton(){}

    public static CacheSingleton getInstance(){
        CacheSingleton instance = map.get(DEFAULT_KEY);
        if(instance == null){
            instance = new CacheSingleton();
            map.put(DEFAULT_KEY,instance);
        }
        return instance;
    }

}
