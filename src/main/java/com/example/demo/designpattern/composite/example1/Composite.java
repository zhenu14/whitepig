package com.example.demo.designpattern.composite.example1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author prayer
 */
public class Composite implements Component {

    private Vector<Component> componentVector = new Vector<>();

    @Override
    public Composite getComposite() {
        return this;
    }

    @Override
    public void sampleOperation() {
        Enumeration enumeration = getChild();
        while (enumeration.hasMoreElements()){
            ((Component)enumeration.nextElement()).sampleOperation();
        }
    }

    /**
     * 聚集管理方法
     * @param component
     */
    public void add(Component component){
        componentVector.addElement(component);
    }

    public void remove(Component component){
        componentVector.removeElement(component);
    }

    /**
     * 返回聚集的Enumeration
     * @return
     */
    public Enumeration getChild(){
        return componentVector.elements();
    }

}
