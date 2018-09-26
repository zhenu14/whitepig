package com.designpattern.demo.bridge.after.hurry;

import com.designpattern.demo.bridge.after.AbsMessage;
import com.designpattern.demo.bridge.after.MessageImplementor;

public class HurryMessage extends AbsMessage{

    public HurryMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public void sendMessage(String message,String toUser){
        message = "特急 ： " + message;
        super.sendMessage(message,toUser);
    }
}
