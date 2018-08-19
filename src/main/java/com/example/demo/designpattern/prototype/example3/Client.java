package com.example.demo.designpattern.prototype.example3;

public class Client {
    public static void main(String [] agrs)   {
        MonthlyLog log = new MonthlyLog();
        Attachment attachment = new Attachment("skrrr");
        log.setAttachment(attachment);

        MonthlyLog log_new = log.clone();
        System.out.println("附件是否相同？" + (log_new.getAttachment() == log.getAttachment()));
    }
}
