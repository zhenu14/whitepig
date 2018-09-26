package com.designpattern.demo.builder.example1;


public class Client {

    public Client(){}

    public static void main(String[] args){
        Builder mingong = new Mingong();
        Designer designer = new Designer();
        designer.order(mingong);
        Room room = mingong.getRoom();
        System.out.println(room.getWindow());
    }

}