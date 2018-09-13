package com.example.demo.designpattern.composite.example2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文件 相当于Leaf
 * @author prayer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File implements Root{

    private String name;

    @Override
    public boolean addFile(Root file) {
        return false;
    }

    @Override
    public boolean removeFile(Root file) {
        return false;
    }

    @Override
    public List<Root> getFiles() {
        return null;
    }

    @Override
    public void display() {
        System.out.println("    |____" + name);
    }
}
