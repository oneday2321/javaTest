package com.test2;

public class staticTest {

    private String name;
    private int age;

    public static String phone;

    public staticTest() {
    }

    public staticTest(String name, int age) {
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

    public void student() {
        System.out.println(name + " 在看书");
    }

    public void show() {
        System.out.println(name + ", " + age +", "+phone);
    }
}
