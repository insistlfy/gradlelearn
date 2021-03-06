package com.my.string;

import java.lang.reflect.Field;

/**
 * TestString001
 *
 * @author lfy
 * @date 2020/3/25
 **/
public class TestString001 {

    public static void main(String[] args) {

        //**************************①**********************************//
        String a = "hello";

        //打印a的内存地址
        System.out.println("a的内存地址为 : " + System.identityHashCode(a));
        System.out.println(a);

        String b = "world";
        a += b;

        System.out.println("拼接后a的内存地址为 : " + System.identityHashCode(a));
        System.out.println("b的内存地址为 : " + System.identityHashCode(b));
        System.out.println(a);
        System.out.println(b);

        a = "你好";
        System.out.println("拼接后a的内存地址为 : " + System.identityHashCode(a));
        System.out.println(a);
        System.out.println("**************************①**********************************");

        //*******************************②*****************************//

        //String真的不可变吗?

        String java = "java";
        System.out.println("修改前 : " + java);
        System.out.println("修改前的内存地址 : " + System.identityHashCode(java));

        try {
            //获取String中的value字段
            Field field = String.class.getDeclaredField("value");
            //改变value属性的访问权限
            field.setAccessible(true);
            //获取value属性的值
            char[] value = (char[]) field.get("java");
            value[0] = '?';
            System.out.println("修改后 : " + java);
            System.out.println("修改后的内存地址 : " + System.identityHashCode(java));
            System.out.println("*******************************②*****************************");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        //*******************************③*****************************//

        // String trim() ?

        String str = " java  ";
        String str1 = str.trim();
        String str2 = "java";
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str1);
        System.out.println(str1.length());
        //此处需关注trim()的源码
        System.out.println(str1 == str2);
        System.out.println("*******************************③*****************************");

        //*******************************④*****************************//
        // String的数据结构

        String str01 = "hello";
        String str02 = new String("hello");
        char[] str03 = {'h', 'e', 'l', 'l', 'o'};
        String str04 = "hel" + "lo";
        System.out.println(str01 == str02);
        System.out.println(str01 == str04);
        System.out.println(str01.equals(str03));
        System.out.println("*******************************④*****************************");


        //*******************************⑤*****************************//
        // String "+" 底层通过StringBuilder拼接
        String str001 = "a" + "b";

        //线程安全
        StringBuffer str002 = new StringBuffer("1");

        //非线程安全
        StringBuilder str003 = new StringBuilder("2");


        System.out.println("*******************************⑤*****************************");
    }
}
