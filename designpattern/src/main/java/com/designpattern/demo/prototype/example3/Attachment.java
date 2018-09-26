package com.designpattern.demo.prototype.example3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment implements Serializable {
    private String name;

    public void download(){
        System.out.println("下载附件。。。。。。" + name);
    }
}
