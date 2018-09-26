package com.designpattern.demo.composite.example2;

/**
 * 使用类
 * @author prayer
 */
public class Client {
    public static void main(String[] a){

        Root root1 = new Folder("c://");
        Root root2 = new Folder("d://");

        Root win = new Folder("windows");
        Root sys = new Folder("system");

        Root hw = new File("HelloWorld.java");

        sys.addFile(hw);
        root1.addFile(win);
        root1.addFile(sys);


        root1.display();
        root2.display();

    }
}
