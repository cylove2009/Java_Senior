package com.yi.genericExample;

public class User {

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;


    }
}
