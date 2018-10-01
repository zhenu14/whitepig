package com.feature.demo.chapter6.collector;

import com.feature.demo.chapter4.stream.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class CollectorTest {

    public enum CaloriesLevel {DIET,NORMAL,FAT}

    List<Dish> menu = new ArrayList<>();

    @Before
    public void setUp(){
        menu = Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,400, Dish.Type.MEAT),
                new Dish("french fries",false,530, Dish.Type.OTHER),
                new Dish("rice",true,365, Dish.Type.OTHER),
                new Dish("fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.OTHER),
                new Dish("salmon",false,450, Dish.Type.FISH)
        );
    }

    @Test
    public void testCount(){
        long count = menu.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    @Test
    public void testGroupingBy(){
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect);

        Map<CaloriesLevel, List<Dish>> caloriesLevelListMap = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloriesLevel.DIET;
            } else if (dish.getCalories() <= 650) {
                return CaloriesLevel.NORMAL;
            } else {
                return CaloriesLevel.FAT;
            }
        }));

        System.out.println(caloriesLevelListMap);

//        Map<Dish.Type, Map<CaloriesLevel, List<Dish>>>  collect1 = menu.stream()
//                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) {
//                        return CaloriesLevel.DIET;
//                    } else if (dish.getCalories() <= 650) {
//                        return CaloriesLevel.NORMAL;
//                    } else {
//                        return CaloriesLevel.FAT;
//                    }
//                })));
//        System.out.println(collect1);

    }


    @Test
    public void testSumming(){
        int totalIntCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalIntCalories : " + totalIntCalories);

        double totalDoubleCalories = menu.stream().collect(Collectors.summingDouble(Dish::getCalories));
        System.out.println("totalDoubleCalories : " + totalDoubleCalories);

        long totalLongCalories = menu.stream().collect(Collectors.summingLong(Dish::getCalories));
        System.out.println("totalLongCalories : " + totalLongCalories);
    }

    @Test
    public void testAverage(){
        double avgDouble = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println(avgDouble);
    }

    @Test
    public void testSummarizing(){
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        DoubleSummaryStatistics doubleSummaryStatistics = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        System.out.println(doubleSummaryStatistics);

        LongSummaryStatistics longSummaryStatistics = menu.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        System.out.println(longSummaryStatistics);
    }

    @Test
    public void testJoin(){
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void testPatitioned(){

    }


}
