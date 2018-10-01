package com.feature.demo.chapter5.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    public void createStreamFromCollection(){
        List<Integer> numbers = Arrays.asList(1,5,9,7,5,3,6,4,8,2,2,2,11);
        Stream<Integer> stream = numbers.stream();
        stream.sorted()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void createStreamFromValues(){
        Stream<Integer> stream = Stream.of(1,5,9,7,5,3,6,4,8,2,2,2,11);
        stream.distinct().forEach(System.out::println);
    }

    @Test
    public void createStreamFromArrays(){
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,5,9,7,5,3,6,4,8,2,2,2,11});
        stream.distinct().forEach(System.out::println);
    }

    @Test
    public void createStreamFromFile(){
        Path path = Paths.get("C:\\ideaCode\\java8feature\\src\\main\\resources\\test.txt");
        try{
            Stream<String> stream = Files.lines(path);
            stream.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    @Test
    public void createStreamFromIterate(){
        Stream<Integer> stream = Stream.iterate(0,n -> n + 2).limit(10);
        stream.forEach(System.out::println);
    }

    @Test
    public void createStreamFromGenerate(){
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(10).forEach(System.out::println);
    }


}
