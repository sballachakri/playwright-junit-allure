package org.example.examples.collections;
//variables
//int x=2;
//x represents 2

// Arrays
//Student[] s=new Student[1000]
//Limitations of Arrays
//1. fixed in size = once arrays is declared we can't increase or decrease.
//2. Arrays can hold homogeneous data types.
//3. No underlying data structure - no ready made methods available to perform, eg: search an element in Array.

//Collection - a group individuals objects
// to overcome all the above Collection are used
// Growable in nature
// holds homogeneous and hetrogeneous data types
// Standard data structure - ready made methods available

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
