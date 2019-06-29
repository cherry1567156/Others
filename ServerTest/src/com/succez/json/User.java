package com.succez.json;

import com.google.gson.annotations.SerializedName;

public class User {
    //将java对象的属性转换成指定的json名字
    @SerializedName("username")
    private String name;
    private int age;

    public User() {
        super();
    }

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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