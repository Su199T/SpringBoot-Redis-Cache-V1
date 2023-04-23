package com.javabootpro.utils.reflect.clazzparse;



public class ClazzParseUtil {

    public static <T> T parseClazzType(T t){
        return t;
    }

    public static <T> T parse2ClazzType(Object arg){
//        if (arg instanceof UserDO){
//
//        }else if (arg instanceof UserDTO){
//
//        }
        return (T) arg;
    }
}
