package com.designpattern.demo.bridge.before.hurry;

import com.designpattern.demo.bridge.before.Message;

public interface HurryMessage extends Message {

    void hurry(String messageId);

}
