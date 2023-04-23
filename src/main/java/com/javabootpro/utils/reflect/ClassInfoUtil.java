package com.javabootpro.utils.reflect;


import java.lang.reflect.Field;
import java.util.Date;

public class ClassInfoUtil {


/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 *
 * @since：2015-5-25 下午07:02:09
 *
 */

// https://www.jianshu.com/p/5b03147d7269

    public static void getParameters(Class<?> clazz) {

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }
    }

    public static void getFieldsValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        /**
         * 基本类型、包装类型、String类型
         */
        String[] types = {"java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "int","double","long","short","byte","boolean","char","float"};
        for(Field f : fields){
            f.setAccessible(true);
            try {
                for(String str : types) {
                    if(f.getType().getName().equals(str)){
                        System.out.println("字段："+f.getName()+" 类型为："+f.getType().getName()+" 值为："+ f.get(obj));
                    }

                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        UserDO userDO = new UserDO().setId("AAA").setRegisterDate(new Date());
//        getFieldsValue(userDO);
    }

}