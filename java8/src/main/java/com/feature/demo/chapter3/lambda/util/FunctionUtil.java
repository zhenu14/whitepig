package com.feature.demo.chapter3.lambda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionUtil {

    /**
     *  Predicate<T> 接口 传入T类型参数，test方法返回boolean类型
     * @param source
     * @param predicate
     * @return
     */
    public static List<Integer> predicateFilter(List<Integer> source, Predicate<Integer> predicate){
        List<Integer> result = new ArrayList<>();
        source.stream().forEach(integer -> {
            if(predicate.test(integer)){
                result.add(integer);
            }
        });
        return result;
    }

    /**
     *  Consumer<T> 接口 传入T类型参数，accept方法void返回类型
     * @param source
     * @param consumer
     * @return
     */
    public static void consumerFilter(List<Integer> source, Consumer<Integer> consumer){
        source.stream().forEach(consumer::accept);
    }

    /**
     *  Function<T,R> 传入两个参数，T为apply方法的参数，R为返回类型
     * @param source
     * @param function
     * @return
     */
    public static List<Integer> functionFilter(List<Integer> source, Function<Integer,Integer> function){
        List<Integer> result = new ArrayList<>();
        source.stream().forEach(integer -> {
            result.add(function.apply(integer));
        });
        return result;
    }

    /**
     * 传入参数T，get方法返回类型为T
     * @param source
     * @param function
     * @return
     */
    public static List<Integer> supplierFilter(List<Integer> source, Supplier<Integer> function){
        List<Integer> result = new ArrayList<>();
        result.add(function.get());
        return result;
    }
}
