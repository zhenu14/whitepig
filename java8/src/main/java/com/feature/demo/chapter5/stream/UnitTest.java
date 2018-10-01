package com.feature.demo.chapter5.stream;

import com.feature.demo.chapter5.stream.bean.Trader;
import com.feature.demo.chapter5.stream.bean.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UnitTest {

    List<Transaction> transactions;

    @Before
    public void setUp(){
        Trader trader1 = new Trader("raoul","beijing");
        Trader trader2 = new Trader("ljj","beijing");
        Trader trader3 = new Trader("chencw","huizhou");
        Trader trader4 = new Trader("cailan","guangzhou");
        Trader trader5 = new Trader("weixia","shenzhen");
        transactions = Arrays.asList(
                new Transaction(trader1,2018,30001),
                new Transaction(trader2,2017,30800),
                new Transaction(trader3,2016,50000),
                new Transaction(trader4,2015,12000),
                new Transaction(trader5,2018,30000),
                new Transaction(trader2,2016,25000),
                new Transaction(trader4,2017,10000)
        );
    }

    @Test
    public void test1(){
        List<Transaction> result = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2018)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void test2(){
        List<String> result = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void test3(){
        List<Trader> result = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("beijing"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void test4(){
        List<String> result = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void test5(){
        Boolean flag = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("beijing"));
        System.out.println(flag);
    }

    @Test
    public void test6(){
        List<Integer> result = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("beijing"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test7(){
        Optional<Integer> result = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(result);
    }
    @Test
    public void test8(){
        Optional<Transaction> transaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(transaction.get());
    }
    @Test
    public void test9(){
        Optional<Integer> result = transactions.stream()
                .map(Transaction::getValue)
                .reduce((a, b) -> a + b);
        System.out.println(result.get());
    }

}
