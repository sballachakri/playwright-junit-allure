package org.example.examples.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        List<String> v=new Vector<>();
        l.add("a");
        l.add("b");
        System.out.println(l);
        v.add("v1");
        v.add("v2");
        System.out.println(v);
        Object[] str= l.toArray();
//        System.out.println(str.length);
//        System.out.println(str[1]);

        Iterator<String> itr=l.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }



}
