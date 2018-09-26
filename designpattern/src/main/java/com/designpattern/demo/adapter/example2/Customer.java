package com.designpattern.demo.adapter.example2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public static final String US = "US";
    public static final String CANADA = "canada";
    private String address;
    private String name;
    private String zip,state,type;

    public boolean isValidAddress(){
        AddressValidator validator = getValidator(Customer.US);

        return validator.isValidAddress(address,zip,state);
    }

    private AddressValidator getValidator(String custType){
        AddressValidator validator = null;
        if(custType.equals(Customer.US)){
            validator = new USAddress();
        }
        return validator;
    }

}
