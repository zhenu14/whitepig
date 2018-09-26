package com.designpattern.demo.composite.example3;

import java.util.Iterator;
import java.util.Vector;

public class Client {

    private static final String tab = "\t";

    public static void main(String[] a){
        test();
    }

    private static void test() {
        Folder root = new Folder("树根");

        Folder b1_1 = new Folder("1_枝1");
        Folder b1_2 = new Folder("1_枝2");
        Folder b1_3 = new Folder("1_枝3");

        File l1_1 = new File("1_叶_1");
        File l1_2 = new File("1_叶_2");
        File l1_3 = new File("1_叶_3");

        Folder b2_1 = new Folder("2_枝1");
        Folder b2_2 = new Folder("2_枝2");

        File l2_1 = new File("2_叶_1");

        //缔造树层次关系
        root.add(b1_1);
        root.add(b1_2);
        root.add(b1_3);

        b1_3.add(l1_1);
        b1_3.add(l1_2);

        b1_2.add(b2_1);
        b1_2.add(b2_2);
        b1_2.add(l2_1);

        root.add(l1_3);
        root.add(b1_3);

        outTree(root);
    }

    private static void outTree(Folder root) {
        System.out.println(root.getName());
        iterateTree(root);
    }

    private static void iterateTree(Folder root) {
        Vector childList = root.getFiles();

        for(Iterator<IFile> it = childList.iterator(); it.hasNext();){
            IFile em = it.next();

            if(em instanceof Folder){
                Folder cm = (Folder)em;
                System.out.println(getIndents(em.getDeep()) + cm.getName());
                iterateTree(cm);
            }else {
                System.out.println(getIndents(em.getDeep()) + ((File)em).getName());
            }
        }
    }

    private static String getIndents(int deep) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < deep;i++){
            stringBuilder.append(tab);
        }
        return stringBuilder.toString();
    }


}
