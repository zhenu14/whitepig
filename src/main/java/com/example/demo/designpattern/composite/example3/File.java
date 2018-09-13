package com.example.demo.designpattern.composite.example3;

public class File implements IFile {

    private String name;
    private int deep;

    public File(String name){
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
