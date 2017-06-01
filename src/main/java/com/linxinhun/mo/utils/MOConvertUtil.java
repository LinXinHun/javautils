package com.linxinhun.mo.utils;

import com.linxinhun.mo.entity.GreenTea;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhoulin on 2017/5/31.
 */
public class MOConvertUtil {

    /***
     * 实体类转Map
     * @param object
     * @return
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Class cls = object.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(cls);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors){
            String propertyName = pd.getName();
            if(!propertyName.equals("class")){
                Method method = pd.getReadMethod();
                Object obj = null;
                obj = method.invoke(object);
                if(obj != null){
                    map.put(propertyName, obj);
                }else map.put(propertyName, "");
            }
        }
        return map;
    }

    /***
     * Map转实体类
     * @param cls
     * @param map
     * @return
     * @throws Exception
     */
    public static Object mapToBean(Class cls, Map map) throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(cls);
        Object obj = cls.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors){
            String propertyName = pd.getName();
            if(map.containsKey(propertyName)){
                Object value = map.get(propertyName);
                pd.getWriteMethod().invoke(obj, value);
            }
        }
        return obj;
    }


    public static void main(String[] args) throws Exception {
        GreenTea greenTea = new GreenTea();
        greenTea.setName("绿茶");
        greenTea.setColor("green");

        Map<String, Object> map = beanToMap(greenTea);

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            String value = (String)map.get(key);
            System.out.print("key: " + key + ", value: " + value);
            System.out.println();
        }

        System.out.println();

        greenTea = new GreenTea();
        greenTea = (GreenTea) mapToBean(greenTea.getClass(), map);

        System.out.print(greenTea.toString());
        System.out.println();

    }

}
