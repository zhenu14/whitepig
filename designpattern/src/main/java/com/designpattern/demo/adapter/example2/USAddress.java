package com.designpattern.demo.adapter.example2;

public class USAddress implements AddressValidator {
    @Override
    public boolean isValidAddress(String address, String zip, String state) {
        if(address.length() < 5){
            return false;
        }
        if(zip.length() < 5 || zip.length() > 10){
            return false;
        }
        if(state.length() != 2){
            return false;
        }
        return true;
    }
}
