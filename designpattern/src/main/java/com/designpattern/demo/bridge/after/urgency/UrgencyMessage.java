package com.designpattern.demo.bridge.after.urgency;

import com.designpattern.demo.bridge.after.AbsMessage;
import com.designpattern.demo.bridge.after.MessageImplementor;

public class UrgencyMessage extends AbsMessage {
    public UrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public Object watch(String messageId){
        return null;
    }

    @Override
    public void sendMessage(String message, String toUser){
        message = "加急 ： " + message;
        super.sendMessage(message,toUser);
    }
}
