package com.example.demo.designpattern.bridge.after.hurry;

import com.example.demo.designpattern.bridge.after.AbsMessage;
import com.example.demo.designpattern.bridge.after.MessageImplementor;

public class HurryMessage extends AbsMessage{

    public HurryMessage(MessageImplementor implementor) {
        super(implementor);
    }

    public void sendMessage(String message,String toUser){
        message = "特急 ： " + message;
        super.sendMessage(message,toUser);
    }
}
