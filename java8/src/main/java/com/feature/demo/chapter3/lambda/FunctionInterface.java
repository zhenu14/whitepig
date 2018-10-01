package com.feature.demo.chapter3.lambda;


import com.feature.demo.chapter3.lambda.util.FunctionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionInterface {

    public static void main(String[] s){

        List<Integer> list = Arrays.asList(5,4,8,9,2,4,7,3,0);

        List<Integer> predicateList = FunctionUtil.predicateFilter(list, (o1) -> o1 > 5);
        System.out.println(predicateList);

        FunctionUtil.consumerFilter(list, (o1) -> {
            if(o1 > 5){
                System.out.println(o1);
            }
        });

        List<Integer> functionList = FunctionUtil.functionFilter(list, (o1) -> o1 * 10);
        System.out.println(functionList);

        List<Integer> supplierList = FunctionUtil.supplierFilter(list, () -> 10);
        System.out.println(supplierList);

    }
}
