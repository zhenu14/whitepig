package com.message.demo.util;

import java.util.Random;

public class VerificationUtils {

    /**
     * 生成验证码
     * @return String
     */
    public static String createVerificationCode()
    {
        Random rad=new Random();
        String result =  rad.nextInt(10000)+"";

        if(result.length()!=4){
            return createVerificationCode();
        }

        return result;
    }

}
