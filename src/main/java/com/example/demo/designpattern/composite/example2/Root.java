package com.example.demo.designpattern.composite.example2;

import java.util.List;

/**
 * File与Folder的共同接口，相当于Component
 * @author prayer
 */
public interface Root {

    boolean addFile(Root file);

    boolean removeFile(Root file);

    List<Root> getFiles();

    void display();

}
