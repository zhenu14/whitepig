package com.feature.demo.chapter5.stream;

import com.feature.demo.chapter4.stream.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStreamTest {

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
    public void test1(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Integer sum1 = numbers.stream().reduce(1, (a, b) -> {
            System.out.println("a : " + a + "\t b : " + b);
            return a * b;
        });
        System.out.println(sum1);

        Optional sum2 = numbers.stream().reduce( (a, b) -> {
            System.out.println("a : " + a + "\t b : " + b);
            return a * b;
        });
        System.out.println(sum2);
    }

    @Test
    public void test2(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Optional max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        Optional min = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());
    }

    /**
     *  用map-reduce模式计算流中有多少个元素
     *  map把每个元素映射成数字1，然后用reduce求和
     */
    @Test
    public void test3(){
        Optional<Integer> sum = menu.stream()
                .map(dish -> 1)
                .reduce((a,b)-> a+b);
        System.out.println(sum);
    }

    @Test
    public void test4(){
        Optional<Dish> reduce = menu.stream()
                .reduce((a, b) -> a.getType() == b.getType() ? a : b);
        System.out.println(reduce);
    }
}
