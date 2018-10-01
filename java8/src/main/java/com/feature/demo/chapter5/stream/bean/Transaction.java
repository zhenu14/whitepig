package com.feature.demo.chapter5.stream.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Transaction {
    private final Trader trader;
    private final int year;
    private final  int value;
}
