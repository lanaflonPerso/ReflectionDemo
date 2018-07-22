package ru.ivmiit.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        Class aClass = Class.forName(className); // содержет информацию о классе который вводим в консоли

        Field fields[] = aClass.getFields();//получаю открытые поля этого класса

        for(Field field : fields) {
            System.out.println(field.getType() + " " + field.getName()); //вывод полей на экран
        }

        Class types[] = new Class[fields.length]; //массив типов, тип каждого поля

        for (int i=0;i<types.length;i++){
            types[i] = fields[i].getType();
        }
        //Object object = aClass.newInstance(); пустой конструктор

        Constructor constructor = aClass.getDeclaredConstructor(types); // выберает конструктор с нужными полями

        for(Class parameterType: constructor.getParameterTypes()){
            System.out.println(parameterType.getName());
        }

        Integer intValue = 0;
        String stringValue = "";
        for (int i = 0; i < fields.length; i++){
            if(types[i].getName().equals("int")) {
                intValue = scanner.nextInt();
            }else  if(types[i].getName().equals("java.lang.String")){
                stringValue = scanner.next();
            }
        }
        Object arguments[] = {intValue, stringValue};
        Object object = constructor.newInstance(arguments);
        System.out.println(object);
    }
}
