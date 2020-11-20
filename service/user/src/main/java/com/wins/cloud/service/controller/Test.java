package com.wins.cloud.service.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    private void grade(int a){
        System.out.println("int "+a);
    }

    private void grade(Integer a){
        System.out.println("Integer "+a);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method grade = Test.class.getDeclaredMethod("grade", Integer.TYPE);
        Object o = new Test();
        grade.invoke(o,Integer.valueOf(1));
    }
}
