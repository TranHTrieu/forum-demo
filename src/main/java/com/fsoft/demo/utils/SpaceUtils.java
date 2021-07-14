package com.fsoft.demo.utils;

import antlr.StringUtils;
import sun.rmi.runtime.Log;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
//import org.apache.log4j.Logger;
public class SpaceUtils {

    public static final String EMPTY = "";
//    private static final Logger LOGGER = Logger.getLogger(SpaceUtils.class.getName());

    public static Object trimReflective(Object object){
        if (object == null){
            return null;
        }

        Class<? extends Object> c = object.getClass();

        String property = EMPTY;
        try {
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(c, Object.class).getPropertyDescriptors()){
                Method method = propertyDescriptor.getReadMethod();
                String name = method.getName();
                if (method.getReturnType().equals(String.class)){
                    property = (String) method.invoke(object);
                    if (property != null){
                        String methodName = "set" + name.substring(3);
                        try {
                            Method setter = c.getMethod(methodName, new Class<?>[] {String.class});
                            if(setter != null){
                                setter.invoke(object, SpaceUtils.trimToNull(property)) ;
                            }
                        }catch (NoSuchMethodException e){
                            e.printStackTrace();
//                            LOGGER.warn("String cannot be trimed because '" + methodName + "' find not found");
                        }
                    }
                }
            }
        }catch (Exception e){
//            LOGGER.error(property);
//            LOGGER.error("String cannot be trimed because: ", e);
            e.printStackTrace();
        }
        return object;
    }


    private static String trimToNull(String str){
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    private static String trim(String str){
        return str == null ? null : str.trim();
    }

    private static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }
}
