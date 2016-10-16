package util.test;//package main
//注意不要添加包名称，否则会报错。

import javax.swing.tree.TreeModel;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        TreeModel treeModel;
        TreeMap map = new TreeMap();
        map.put(1, 1);
        map.put(1, 2);
        map.put(12, 3);
        map.put(4, null);
        map.put(5, null);
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}

class Person {
    int age;
    String name;
}
