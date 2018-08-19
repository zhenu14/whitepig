package com.example.demo.designpattern.prototype.example3;

/**
 * 1.性能优良
 * 原型模式是内存二进制流的拷贝，要比直接new一个对象性能好很多
 * 特别是要在循环体内产生大量的对象时，原型模式可以更好地体现其优点
 * 2.逃避构造函数的约束
 * 直接在内存中拷贝，构造函数是不会执行的。
 *
 * 使用场景：
 * 1.资源优化场景     类初始化需要消耗非常多的资源
 * 2.性能和安全要求的场景     通过new产生一个对象需要非常繁琐的数据准备或访问权限，可以使用原型模式
 * 3.一个对象多个修改者的场景
 *
 * 在项目中原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法创建一个对象
 * 然后由工厂方法提供给调用者
 *
 */
public class Client {
    public static void main(String [] agrs)   {
        MonthlyLog log = new MonthlyLog();
        Attachment attachment = new Attachment("skrrr");
        log.setAttachment(attachment);

        MonthlyLog log_new = log.clone();
        System.out.println("附件是否相同？" + (log_new.getAttachment() == log.getAttachment()));
    }
}
