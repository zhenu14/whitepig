package com.feature.demo.chapter2.parameterize.apple.attempt4;


import com.feature.demo.chapter2.parameterize.apple.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {

    public static <T>List<T> filter(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.filter(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<Apple> apples = Arrays.asList(
                new Apple("green",180),
                new Apple("red",140),
                new Apple("green",130),
                new Apple("red",210),
                new Apple("yellow",180));

        List<Apple> temp1 = filter(apples, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(temp1);
        List<Apple> temp2 = filter(apples, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(temp2);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> temp3 = filter(numbers,(Integer i) -> i > 5);
        System.out.println(temp3);
    }
}
