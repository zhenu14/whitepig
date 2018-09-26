package com.designpattern.demo.composite.example2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录。目录下面有子目录、文件，相当于Compisite
 * @author prayer
 */
@Data
public class Folder implements Root{

    private String name;

    private List<Root> folder;

    public Folder(String name){
        this.name = name;
        folder = new ArrayList<>();
    }

    @Override
    public boolean addFile(Root file) {
        return folder.add(file);
    }

    @Override
    public boolean removeFile(Root file) {
        return folder.remove(file);
    }

    @Override
    public List<Root> getFiles() {
        return folder;
    }

    @Override
    public void display() {
        System.out.println(name);
        for(Root file : folder){
            if(file instanceof Folder){
                System.out.print("|____");
            }
            file.display();
        }
    }
}
