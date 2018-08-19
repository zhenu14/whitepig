package com.example.demo.designpattern.prototype.example2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mail implements Cloneable {
    private String receiver;

    private String subject;

    private String appellation;

    private String context;

    private String tail;

    public Mail(AdvTemplate advTemplate){
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    @Override
    public Mail clone(){
//        Mail mail = new Mail();
//        mail.setReceiver(this.getReceiver() == null ? "" : this.getReceiver());
//        mail.setAppellation(this.getAppellation() == null ? "" : this.getAppellation());
//        mail.setTail(this.getTail() == null ? "" : this.getTail());
//        mail.setContext(this.getContext() == null ? "" : this.getContext());
//        mail.setSubject(this.getSubject() == null ? "" : this.getSubject());
        Mail mail = null;
        try{
            mail = (Mail) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return mail;
    }

}
