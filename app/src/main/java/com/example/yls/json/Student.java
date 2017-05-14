package com.example.yls.json;

/**
 * Created by yls on 2017/3/2.
 */

public class Student {
    int id;
    String name;
    int age;
public Student(int id,String name,int  age){
this.id=id;
    this.age=age;
    this.name=name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
