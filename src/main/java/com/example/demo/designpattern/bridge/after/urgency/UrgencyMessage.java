package com.example.demo.designpattern.bridge.after.urgency;

import com.example.demo.designpattern.bridge.after.AbsMessage;
import com.example.demo.designpattern.bridge.after.MessageImplementor;

public class UrgencyMessage extends AbsMessage {
    public UrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public Object watch(String messageId){
        return null;
    }

    public void sendMessage(String message,String toUser){
        message = "加急 ： " + message;
        super.sendMessage(message,toUser);
    }
}
