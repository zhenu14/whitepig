package com.designpattern.demo.composite.example3;

import java.util.Vector;

public class Folder implements IFile {

    private String name;
    private int deep;
    private Vector<IFile> files = new Vector<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(IFile file){
        files.addElement(file);
        file.setDeep(this.deep + 1);
    }

    public void remove(IFile file){
        files.removeElement(file);
    }

    public Vector<IFile> getFiles() {
        return files;
    }

    @Override
    public IFile getComposite() {
        return this;
    }

    @Override
    public void sampleOperation() {
        System.out.println("执行了某个业务方法");
    }

    @Override
    public int getDeep() {
        return deep;
    }

    @Override
    public void setDeep(int x) {
        this.deep = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
