package com.example.demo.designpattern.composite.example1;

/**
 * @author prayer
 */
public interface Component {
    /**
     * 返回自己的实例
     * @return
     */
    Composite getComposite();

    /**
     * 业务方法
     */
    void sampleOperation();

}
