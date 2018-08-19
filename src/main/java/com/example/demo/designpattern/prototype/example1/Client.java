package com.example.demo.designpattern.prototype.example1;

public class Client {

    public static void main(String [] agrs) throws CloneNotSupportedException {
        GouClone gouClone = new GouClone();
        gouClone.setLegCounts(3);
        System.out.println(gouClone.getLegCounts());
        System.out.println(gouClone.getDog());

        GouClone gouClone1 = gouClone.clone();
        gouClone1.setLegCounts(1);
        Dog dog = gouClone1.getDog();
        dog.changeLegCounts();

        System.out.println(gouClone.getLegCounts());
        System.out.println(gouClone.getDog());

        System.out.println(gouClone1.getLegCounts());
        System.out.println(gouClone1.getDog());

    }

}
