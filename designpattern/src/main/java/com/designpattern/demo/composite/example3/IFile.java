package com.designpattern.demo.composite.example3;

/**
 * 抽象文件角色
 * @author prayer
 */
public interface IFile {

    IFile getComposite();

    void sampleOperation();

    int getDeep();

    void setDeep(int x);

}
