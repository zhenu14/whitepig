package com.designpattern.demo.singleton;

import java.util.HashMap;
import java.util.Map;

public class OneExtend {

    private final static String DEFAULT_KEY = "Cache";

    private static Map<String,OneExtend> map = new HashMap<>();

    private OneExtend(){}

    private static int num = 1;

    private final static int NUM_MAX = 3;

    public static OneExtend getInstance(){
        String key = DEFAULT_KEY + num;
        OneExtend oneExtend = map.get(key);
        if(oneExtend == null){
            oneExtend = new OneExtend();
            map.put(key,oneExtend);
        }
        num++;
        if(num > NUM_MAX){
            num  = 1;
        }
        return oneExtend;
    }

    public static void main(String[] args){
        OneExtend t1 = getInstance();
        OneExtend t2 = getInstance();
        OneExtend t3 = getInstance();
        OneExtend t4 = getInstance();
        OneExtend t5 = getInstance();
        OneExtend t6 = getInstance();

        System.out.println("t1==" + t1);
        System.out.println("t2==" + t2);
        System.out.println("t3==" + t3);
        System.out.println("t4==" + t4);
        System.out.println("t5==" + t5);
        System.out.println("t6==" + t6);
    }

}
