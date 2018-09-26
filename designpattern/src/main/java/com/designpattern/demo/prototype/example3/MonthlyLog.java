package com.designpattern.demo.prototype.example3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonthlyLog implements Cloneable,Serializable{

    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    /**
     * 浅拷贝
     * @return
     */
//    @Override
//    public MonthlyLog clone(){
//        MonthlyLog object = null;
//        try{
//            object = (MonthlyLog) super.clone();
//        }catch (CloneNotSupportedException e){
//            e.printStackTrace();
//        }
//        return object;
//    }

    /**
     * 使用序列化技术实现深拷贝
     * @return
     */
    @Override
    public MonthlyLog clone(){
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (MonthlyLog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("拷贝失败啊");
            e.printStackTrace();
        }
        return null;
    }

}
