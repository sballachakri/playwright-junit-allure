package org.example.examples.constructors;
//constructor - to perform initialization of object/instance variable
//name of the constructor should be same of the class
//if no constructor is declared the default constructor is created by
//**constructor purpose is not to create objects.

public class Student {
    String name;
    int rollNo;
    Student(String n,int r){
        this.name=n;
        this.rollNo=r;
    }
    public static void main(String[] args) {
        Student s1=new Student("jack",1);
        Student s2=new Student("tom",2);

        System.out.println(s1.name);
        System.out.println(s1.rollNo);
        System.out.println(s2.name);
        System.out.println(s2.rollNo);
    }

}
