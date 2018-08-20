package com.example.demo.designpattern.bridge.after.common;

import com.example.demo.designpattern.bridge.after.AbsMessage;
import com.example.demo.designpattern.bridge.after.MessageImplementor;

public class CommonMessage extends AbsMessage {

    public CommonMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public void sendMessage(String message,String toUser){
        super.sendMessage(message,toUser);
    }
}
