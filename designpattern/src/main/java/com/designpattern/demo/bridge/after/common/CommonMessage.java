package com.designpattern.demo.bridge.after.common;

import com.designpattern.demo.bridge.after.AbsMessage;
import com.designpattern.demo.bridge.after.MessageImplementor;

public class CommonMessage extends AbsMessage {

    public CommonMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String toUser){
        super.sendMessage(message,toUser);
    }
}
