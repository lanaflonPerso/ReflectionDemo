package ru.ivmiit.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        SomeClass someClass = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someClass.getClass();
        Field someField = someClassAsClass.getField("someField");
        System.out.println(someField.getType());

        Field[] fields = someClassAsClass.getFields();

        for (Field field: fields){
            System.out.println(field.getType() + " " + field.getName());
        }

        System.out.println(someClass.someField);
        someField.set(someClass, 777);
        System.out.println(someClass.someField);

        Field privateField = someClassAsClass.getDeclaredField("somePrivate");
        System.out.println(privateField.getName());
        privateField.setAccessible(true);
        privateField.set(someClass,"vlad");
        System.out.println(someClass.getSomePrivate());

        Method method = someClassAsClass.getMethod("getSomePrivate");
        System.out.println(method.getName());


    }
}
