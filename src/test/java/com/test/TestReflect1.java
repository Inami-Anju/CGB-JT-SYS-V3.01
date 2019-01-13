package com.test;

import java.io.File;

@interface Config{}

@Config
class DataSourceDemo{
    private int anInt;
    static {System.out.println("static()");}
    public DataSourceDemo() {
        System.out.println("construct()");
    }
}

public class TestReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
    //利用反射扫描加载demo类
        //1获得类全名
        String name="com.test.TestReflect1";
        //2：类被加载进内存（方法区），执行static{},放的是信息：有什么字段，方法。
        //   之后在内存（堆）中创建了类型为Class的对象，对象存储的即类的字节码信息
        //类的成员存进方法区，成员对应的描述性信息放在堆中，根据字节码信息创建实例对象
        final Class<?> pkgClass = Class.forName(name);
        System.out.println(pkgClass);
        //我们第一次new object的时候创建了两个对象，一个是 Class a对象（只存在一个），一个是Object obj对象
        //判定是否有注解

    }
}
