package com.designpattern.demo.builder.example1;

public class Mingong implements  Builder {

    private String window = "";
    private String floor = "";

    @Override
    public void makeWindow() {
        window = "window";
    }

    @Override
    public void makeFloor() {
        floor = "floor";
    }

    @Override
    public Room getRoom() {
        Room r = null;
        if(!window.equals("") && !floor.equals("")){
            r = new Room();
            r.setWindow(window);
            r.setFloor(floor);
        }
        return r;
    }

}
