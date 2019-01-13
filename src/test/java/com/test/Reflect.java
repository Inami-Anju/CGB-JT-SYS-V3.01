package com.test;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Reflect {
    @Test
    //获取接口的实现类
    public void get() throws ClassNotFoundException {
        final Class<?> aClass = Class.forName("com.test.TestBase");
        System.out.println(aClass);

        final Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }
    @Test
    //获得所有父类
    public void get1() throws ClassNotFoundException {
        Class clazz = ArrayList.class;
        while(clazz != null){
            System.out.println(clazz.getName());
            clazz = clazz.getSuperclass();
        }
    }

    @Test
    //获得所有父级接口
    public void get2() throws ClassNotFoundException {
        show(List.class);

    }

    private void show(Class c){
        //System.out.println(c.getName());
        Class[] classes=c.getInterfaces();
        while(classes != null){
            for (Class aClass : classes) {
                System.out.println(aClass.getName());
                show(aClass);

            }
            break;
        }
    }

    interface A{

    }

    class B implements A{

    }
    @Test
    public void test3(){
      File file=new File("D:\\IDEAworkspace\\CGB-JT-SYS-V3.01\\src\\test\\java\\com");
      List<String> list= new ArrayList();
      getSubFileNameList(file, list);
      System.out.println(list.toString());
        for (String o : list) {
            o=o.substring(10);
            System.out.println(o);

            if (isChildClass(o, TestBase.class)) System.out.println("子类有："+o);;
        }
    }

    /**
     *  递归查找指定目录下的类文件的全路径
     * @param baseFile 查找文件的入口
     * @param fileList 保存已经查找到的文件集合
     */
    public  void getSubFileNameList(File baseFile, List<String> fileList){
        if(baseFile.isDirectory()){
            File[] files = baseFile.listFiles();
            for(File tmpFile : files){
                getSubFileNameList(tmpFile,fileList);
            }
        }
        String path = baseFile.getPath();
        if(path.endsWith(".java")){
            String name1 = path.substring(path.indexOf("src")+4, path.length());
            String name2 = name1.replaceAll("\\\\", ".");
            String name3 = name2.substring(0, name2.lastIndexOf(".java"));
            fileList.add(name3);
        }
    }

    /**
     *  判断一个类是否继承某个父类或实现某个接口
     */
    public boolean isChildClass(String className,Class parentClazz){
        if(className == null) return false;

        Class clazz = null;
        try {
            clazz = Class.forName(className);
            if(Modifier.isAbstract(clazz.getModifiers())){//抽象类忽略
                return false;
            }
            if(Modifier.isInterface(clazz.getModifiers())){//接口忽略
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return parentClazz.isAssignableFrom(clazz);

    }

}
