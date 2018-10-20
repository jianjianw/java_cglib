package org.opengg;

import com.google.gson.Gson;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {


    public static void main(String[] args) throws ClassNotFoundException {

        // 设置类成员属性
        HashMap propertyMap = new HashMap();

        propertyMap.put("id", Class.forName("java.lang.Integer"));

        propertyMap.put("name", Class.forName("java.lang.String"));

        propertyMap.put("address", Class.forName("java.lang.String"));

        // 生成动态 Bean
        DynamicBean bean = new DynamicBean(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");

        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();
        List<Object> list = new ArrayList<Object>();
        list.add(object);

        Gson gson = new Gson();
        String s = gson.toJson(object);
        System.out.println("============================="+s);

        // 通过反射查看所有方法名
        Class clazz = object.getClass();
        String name = clazz.getName();
        System.out.println(name);
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }

        out(list);
    }

    public static void out(List<Object> list){
        Object object = list.get(0);
        Gson gson = new Gson();
        String s = gson.toJson(object);
        System.out.println(s);
    }

}
