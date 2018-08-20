package com.example.demo.designpattern.adapter.example2;

public class CAAddressAdapter extends CAAddress implements AddressValidator{
    @Override
    public boolean isValidAddress(String address, String zip, String state) {
        return isValidAddress(address,zip,state);
    }
}
