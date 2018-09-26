package com.designpattern.demo.prototype.example2;

import java.util.Random;

public class Client {

    private static int MAX_COUNT = 6;

    public static void main(String [] agrs)   {

        int i = 0;

        Mail mail = new Mail(AdvTemplate.getInstance());

        mail.setTail("XX银行版权所有");

        while (i < MAX_COUNT){
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandomString(5) + "先生(女士) ： ");
            cloneMail.setReceiver(getRandomString(5) + "@" + getRandomString(4) + ".com");
            sendMain(cloneMail);
            i++;
        }
    }

    public static void sendMain(Mail mail){
        System.out.println(mail);
    }

    public static String getRandomString(int maxLength){
        String source = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBBNM";

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for(int i = 0;i < maxLength;i++){
            stringBuilder.append(source.charAt(random.nextInt(source.length())));
        }
        return stringBuilder.toString();
    }

}
