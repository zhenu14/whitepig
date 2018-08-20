package com.example.demo.designpattern.bridge.before.common;

import com.example.demo.designpattern.bridge.before.Message;

public class CommonMessageEmail implements Message {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件短消息的方法，发送消息 ： " + message + "  给 ===》" + toUser);
    }
}
