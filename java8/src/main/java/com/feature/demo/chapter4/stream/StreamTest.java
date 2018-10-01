package com.feature.demo.chapter4.stream;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] s){
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,400, Dish.Type.MEAT),
                new Dish("french fries",false,530, Dish.Type.OTHER),
                new Dish("rice",true,365, Dish.Type.OTHER),
                new Dish("fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.OTHER),
                new Dish("salmon",false,450, Dish.Type.FISH)
        );

        /**
         *  stream()把集合转成一个流对象。
         *  parallelStream()并行处理的流
         *
         *  流的使用包括：
         *  1.一个数据源(如集合)来执行查询       List等集合
         *  2.一个中间操作链，形成一条流水线     filter,sorted,limit,map,distinct
         *  3.一个终端操作执行流水线，并生成结果 collect,count,forEach
         */
        List<String> lowName = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish);
                    return dish.getCalories() < 500;
                })
//                .sorted(Comparator.comparing(Dish::getCalories))
                .sorted((o1,o2) -> o2.getCalories() > o1.getCalories() ? o2.getCalories() : o1.getCalories())
                .limit(4)
                .map(dish -> {
                    System.out.println("mapping : " + dish);
                    return dish.getName();
                })
//                .map(dish -> dish.getName())
                .collect(toList());
        System.out.println(lowName);

        /**
         *  会报错 stream has already been operated upon or closed
         *  Stream只能遍历一次，遍历完之后这个流已经被消费掉了
         */
//        Stream<Dish> dishes = menu.stream();
//        dishes.forEach(dish -> System.out.println(dish));
//        dishes.forEach(dish -> System.out.println(dish));


    }
}
