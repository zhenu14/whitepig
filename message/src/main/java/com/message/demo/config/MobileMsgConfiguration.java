package com.message.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MobileMsgConfiguration
 *
 * 2018/9/20 10:41
 * @Description:
 */
public class MobileMsgConfiguration {
    
    public static final String EID = "23007016428";
    
    public static  final String USERID = "administrator";
    
    public static  final String PASSWORD = "77ff38ec";
    
    public static  final String KEY = "swr8qwsftnoej8v8";
    
    public static final String URL_SEND = "http://120.197.89.51/SmsHttpInterface/smsService/Do-sendSms.action";
    public static final String URL_REPORT = "http://120.197.89.51/SmsHttpInterface/smsService/Do-getReport.action";
    public static final String URL_RECEIVE = "http://120.197.89.51/SmsHttpInterface/smsService/Do-receive.action";
}
