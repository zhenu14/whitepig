package com.feature.demo.chapter3.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpession {

    public static void main(String[] s){

        List<Integer> list = Arrays.asList(5,4,8,9,2,4,7,3,0);

        //普通方式定义一个比较器
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(list);
        list.sort(integerComparator);
        System.out.println(list);

        Comparator<Integer> lambdaComparator = (o1,o2) -> o2.compareTo(o1);
        list.sort(lambdaComparator);
        System.out.println(list);
    }
}
