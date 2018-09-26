package com.designpattern.demo.bridge.after;

public class MessageMobile implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短信息的方法，发送消息 ： " + message + "  给 ===》" + toUser);
    }
}
