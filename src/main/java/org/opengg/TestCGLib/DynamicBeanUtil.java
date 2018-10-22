package org.opengg.TestCGLib;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.junit.Test;
import org.opengg.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;


import java.lang.reflect.Method;
import java.util.*;

public class DynamicBeanUtil {

    private static Logger logger = LoggerFactory.getLogger(DynamicBeanUtil.class);




    public static Object getDynamicBean(Object object,Map<String,Object> properties){


        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] propertyDescriptors = propertyUtilsBean.getPropertyDescriptors(object);
        //获取原来对象的字段
        Map<String,Object> propertyMap = new HashMap<String, Object>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if (!"class".equalsIgnoreCase(propertyDescriptor.getName())) {
                propertyMap.put(propertyDescriptor.getName(), propertyDescriptor.getPropertyType());
            }
        }

        if(properties != null){
            Set<Map.Entry<String, Object>> entries = properties.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                propertyMap.put(next.getKey(),next.getValue().getClass());
            }
        }

        DynamicBean dynamicBean = new DynamicBean(object.getClass(),propertyMap);



        Set<Map.Entry<String, Object>> entries = propertyMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            try {
                //给原对象的字段赋值
                if(next.getValue() != null){
                    Object nestedProperty = propertyUtilsBean.getNestedProperty(object, next.getKey());
                    dynamicBean.setValue(next.getKey(),nestedProperty);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        Set<Map.Entry<String, Object>> entrySet = properties.entrySet();
        Iterator<Map.Entry<String, Object>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> next = it.next();
            dynamicBean.setValue(next.getKey(),next.getValue());
        }

        return dynamicBean.getObject();

    }

    @Test
    public void test001(){

        User user = new User();
        user.setAge("132");

        Map<String,Object> addMap = new HashMap<String,Object>();
        addMap.put("uri",3);
        Object dynamicBean = DynamicBeanUtil.getDynamicBean(user,addMap);
        System.out.println(dynamicBean);


        User user2 = new User();
        Map<String,Object> amp = new HashMap<String,Object>();
        amp.put("uri",3);
        Object bean = DynamicBeanUtil.getDynamicBean(user,addMap);
        List<Object> list  = new ArrayList<>();
        list.add(bean);
        Object object = list.get(0);
        Class<?> aClass = object.getClass();
        try {

            Method method = aClass.getDeclaredMethod("setUri", Integer.class);
            method.invoke(object, new Object[]{123});

     /*       Method method = aClass.getDeclaredMethod("getUri");
            Integer invoke = (Integer)method.invoke(object);
            System.out.println(invoke);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dynamicBean);

        forList(list);


    }

    public void forList(List<Object> list) {
        for (Object obj : list) {

            String s = JSON.toJSONString(obj);

            System.out.println("++++++++++++++++++++++"+s);
        }
    }
}
