package com.designpattern.demo.bridge.after;

import com.designpattern.demo.bridge.after.common.CommonMessage;
import com.designpattern.demo.bridge.after.hurry.HurryMessage;
import com.designpattern.demo.bridge.after.urgency.UrgencyMessage;

public class Client {
    public static void main(String[] a){
        MessageImplementor implementor = new MessageSMS();
        AbsMessage message = new CommonMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

        message = new UrgencyMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

        message = new HurryMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

        implementor = new MessageMobile();
        message = new CommonMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

        message = new UrgencyMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

        message = new HurryMessage(implementor);
        message.sendMessage("喝杯茶吧","三水水");

    }
}
