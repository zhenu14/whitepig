package com.feature.demo.chapter2.parameterize.apple.attempt1;


import com.feature.demo.chapter2.parameterize.apple.Apple;
import com.feature.demo.chapter2.parameterize.apple.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean filter(Apple apple) {
        return apple.getWeight() > 150;
    }
}
