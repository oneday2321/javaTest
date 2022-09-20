package com.test2;

import static com.test2.staticTest.*;

public class staticDemo1 {
    public static void main(String[] args) {
        phone="231";
        staticTest s1 = new staticTest();
        s1.setName("aaa");
        s1.setAge(12);
        s1.student();
        s1.show();

        staticTest s2 = new staticTest();
        s2.setName("bbb");
        s2.setAge(34);
        s2.student();
        s2.show();
    }
}
