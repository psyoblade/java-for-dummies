package me.suhyuk.mock;

import java.util.List;

public class Person {
    private String name;
    private int age;

    public Person() {
        name = "defaultName";
        age = 0;
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

    public List<String> getList(String name, int age) {
        return null;
    }

}