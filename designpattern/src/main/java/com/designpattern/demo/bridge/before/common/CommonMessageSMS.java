package com.designpattern.demo.bridge.before.common;

import com.designpattern.demo.bridge.before.Message;

public class CommonMessageSMS implements Message {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用系统内短信的方法，发送消息 ： " + message + "  给 ===》" + toUser);
    }
}
