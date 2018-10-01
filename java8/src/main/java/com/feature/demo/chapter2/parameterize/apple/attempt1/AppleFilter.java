package com.feature.demo.chapter2.parameterize.apple.attempt1;


import com.feature.demo.chapter2.parameterize.apple.Apple;
import com.feature.demo.chapter2.parameterize.apple.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple:apples){
            if(applePredicate.filter(apple)){
                result.add(apple);
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

        List<Apple> temp1 = filterApples(apples,new AppleHeavyWeightPredicate());
        System.out.println(temp1);
        List<Apple> temp2 = filterApples(apples,new AppleColorGreenPredicate());
        System.out.println(temp2);
    }
}
