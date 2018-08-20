package com.example.demo.designpattern.bridge.after;

public interface MessageImplementor {
    /**
     * 发送消息
     * @param message 要发送消息的内容
     * @param toUser 消息的接收者
     */
    void send(String message, String toUser);
}
