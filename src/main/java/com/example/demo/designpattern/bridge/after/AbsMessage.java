package com.example.demo.designpattern.bridge.after;

public abstract class AbsMessage {

    protected MessageImplementor messageImplementor;

    public AbsMessage(MessageImplementor implementor){
        messageImplementor = implementor;
    }

    /**
     * 发送消息，转调实现部分的方法
     * @param message  要发送的消息内容
     * @param toUser  消息发送的目的人员
     */
    public void sendMessage(String message,String toUser){
        messageImplementor.send(message,toUser);
    }

}
