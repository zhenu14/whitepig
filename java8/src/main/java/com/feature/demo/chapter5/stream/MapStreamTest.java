package com.feature.demo.chapter5.stream;

import com.feature.demo.chapter4.stream.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MapStreamTest {

    public Stream<String> stringStream;

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

//    @Before
//    public void setUp(){
//        Path path = Paths.get("C:\\ideaCode\\java8feature\\src\\main\\resources\\test.txt");
//        try{
//            stringStream = Files.lines(path).map(s -> s.replaceAll(" ",""));
//        }catch (IOException e ){
//            e.printStackTrace();
//        }
//    }

    @Test
    public void mapTest(){

        Map<Character,Integer> characterIntegerMap = new HashMap<>();

        List<String[]> list1 = stringStream.map(s -> s.split("")).collect(toList());
//        list1.stream().forEach(strings -> System.out.println(strings.length));
        list1.stream()
                .flatMap(Arrays::stream)
//                .distinct().count();
                .forEach(s -> {
                    Character character = s.toCharArray()[0];
                    if(characterIntegerMap.containsKey(character)){
                        characterIntegerMap.put(character,characterIntegerMap.get(character) + 1);
                    }else{
                        characterIntegerMap.put(character,0);
                    }
                });
        System.out.println(characterIntegerMap);
    }

    /**
     * flatMap ： 把流中每个值都换成另一个流，然后把所有流连接起来成一个流
     */
    @Test
    public void flatMapTest(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);
        List<int[]> pairs = list1.stream()
                .flatMap(i -> list2.stream().map(j -> new int[]{i,j})).collect(toList());
        pairs.forEach(pair -> {
            String arrayStr = "";
            for (int i : pair) {
                arrayStr = arrayStr + i + "\t";
            }
            System.out.println(arrayStr);
        });
    }

    @Test
    public void flatMapTest1(){

    }

}
