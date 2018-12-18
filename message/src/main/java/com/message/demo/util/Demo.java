package com.message.demo.util;

public class Demo {

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i ++){
            System.out.println(VerificationUtils.createVerificationCode());
        }
    }

}
