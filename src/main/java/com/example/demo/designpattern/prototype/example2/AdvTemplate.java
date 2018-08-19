package com.example.demo.designpattern.prototype.example2;

import lombok.Data;

@Data
public class AdvTemplate {

    private static AdvTemplate instance = new AdvTemplate();

    private String advSubject = "XX银行信用卡抽奖活动";

    private String advContext = "国庆抽奖活动通知：只要刷卡就送给你一千万现金！！";

    private AdvTemplate(){}

    public static AdvTemplate getInstance(){
        return instance;
    }
}
