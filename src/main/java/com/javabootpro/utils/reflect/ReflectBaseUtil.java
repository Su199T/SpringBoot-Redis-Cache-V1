package com.javabootpro.utils.reflect;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

// Java反射机制(创建Class对象的三种方式)
// https://www.cnblogs.com/qlwang/p/8018175.html

// class<T>和 class<?>类型 有什么区别
// https://www.cnblogs.com/skyislimit/p/5665853.html

// 浅析JAVA反射
// https://juejin.cn/post/6844903583431786510

//Java反射机制
// https://juejin.cn/post/6844903663966617607

//Java自定义注解与设计模式
// https://blog.csdn.net/kai46385076/article/details/93523125

// Java之反射机制六：获取方法的泛型信息
// https://www.cnblogs.com/wwjj4811/p/12592443.html

//Java之反射机制一：获取及其操作类的属性
// https://www.cnblogs.com/wwjj4811/p/12528425.html

// 面试官形式理解
// 【对线面试官】Java反射 && 动态代理
// https://mp.weixin.qq.com/s/hPZkeneJjBCHB2SW3jXFaQ

@Slf4j
public class ReflectBaseUtil {

    /**
     * 基础知识
     * Object obj = new Student();
     * String name = obj.getClass().getName();
     * log.info("name :{}",name);
     * Class resultClass = null;
     * Object resultObj = null;
     * try {
     * resultClass = Class.forName(name);
     * resultObj = resultClass.newInstance(); //必须实例化对象
     * }catch (Exception e){
     * <p>
     * }
     */


    // Java基础系列—Java反射
    // https://juejin.cn/post/6844903601609900045
    // 实现通用数组复制功能
    // 好像有问题????
//        public static <T> T[] copy(T[] clazz) {
//            return (T[]) Array.newInstance(
//                    clazz.getClass().getComponentType(),
//                    clazz.length);
//        }
//
//        public static void main99(String[] args) {
//            Integer[] array = {1, 2, 3};
//            Integer[] copyArray = copy(array);
//            System.out.println(copyArray.length);
//            for (Integer val:copyArray
//                 ) {
//                log.info("{}",val);
//            }
//        }
    private ReflectBaseUtil() {
    }

    public static void main(String[] args) {
        TestReflectDO self = new TestReflectDO().setId("13");
        TestReflectDO should = new TestReflectDO().setId("66").setName("zs");
//        TestReflectDO should2 = returnSelfAndInitFieldIfNull(should);
//        TestReflectDO result = returnSelfAndReplaceSelfFieldIfNull(self, should);
        TestReflectDO result = returnEntityAfterValA2ValB(self,should);
        log.info("{}", result.toString());
    }

    public static void main3(String[] args) throws NoSuchMethodException {
        // map可以
        Method method = ReflectBaseUtil.class.getMethod("parameterTest", Map.class);
        // list同样适用
        String[] arr = getClassMethodGenericParameterName(method);
        for (String val : arr
        ) {
            log.info("val:{}", val);
        }
    }

    public static void main2(String[] args) {
        TestReflectDO reflectDO = new TestReflectDO().setId("13");
        Class getClass = reflectDO.getClass();
        Class cla = TestReflectDO.class;
//        log.info("getClass:{}",getClass); // class com.javabootpro.utils.reflect.TestReflectDO
        log.info("getClass:{},{} ,{} ,{}", getClass, getClass.toString(), getClass.getName(), getClass.getTypeName());
        log.info("cla:{},{} ,{} ,{}", cla, cla.toString(), cla.getName(), cla.getTypeName());
//        log.info("cla.getPackage():{},{}",cla.getPackage(),cla.getPackage().getName());
        log.info("比较: {},{}", getClass.equals(cla), getClass.toString().equals(cla.toString()));

        List<TestReflectDO> list = new ArrayList<>();
        String typeName = list.getClass().getTypeName();
        Field[] fields = list.getClass().getDeclaredFields();
        for (Field f : fields
        ) {
            log.info("f:{}", f);
        }

        // list.getClass().getName() , java.util.ArrayList
        log.info("List<TestReflectDO>: {},{},{}", list.getClass(), list.getClass().getName(), list.getClass().getPackage());
//        Class st = StockDO.class;
//        log.info("st:{}", st);
    }

    public static void main1(String[] args) {

//        getDefault(UserGroupDO.class,userDO);

//       UserDO result = initFieldIfNullTest(userDO);
//       log.info("初始化之后 : {}",result.toString());

        TestReflectDO reflectDO = new TestReflectDO().setId("13");
        log.info("调用反射之前: {}", reflectDO.toString());
        initSelfFieldIfNull(reflectDO);
        log.info("调用反射之后: {}", reflectDO.toString()); // 这个自己本身发生了变化 不需要返回也行
    }

    public void parameterTest(Map<Integer, TestReflectDO> map) {

    }

    public void parameterTest2(List<TestReflectDO> list) {

    }


    /**
     * 使用此种参数传递 报错 没有找到该方法
     * 参数: Class<?> classType,String methodName,Class<?> argType
     * 使用 参考  getClassMethodGenericParameterName(ReflectBaseUtil.class,"parameterTest2",List.class);
     * <p>
     * <p>
     * 所以更改为传 Method
     * <p>
     * // map可以
     * Method method = ReflectBaseUtil.class.getMethod("parameterTest", Map.class);
     *
     * @param method
     * @return 返回这个方法的参数 名称 map是两个类型 ,list是一个，不要使用嵌套
     */
    public static String[] getClassMethodGenericParameterName(Method method) {
        //
//        Method method = null;
//        try {
//            method = classType.getClass().getMethod(methodName, argType);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        StringBuilder builder = new StringBuilder();
        //获取方法的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            // System.out.println("type:"+genericParameterType);
            //ParameterizedType:表示一种参数化类型，比如Collection<Object>
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type parameterType : actualTypeArguments) {
                    // System.out.println(parameterType);
                    builder.append(parameterType + ",");
                }
            }
        }
        return builder.toString().split(",");
    }

    /**
     * 获取 val 的字段名称对应的值
     *
     * @param val
     * @return <字段名称 ,值>
     */
    public static Map<String, Object> getFieldNameAndValue(Object val) {
        return getSelfFieldValue(val);
    }

    /**
     * 获取一个类的所有字段值
     *
     * @param self
     * @return <字段名称 ,值>
     */
    private static Map<String, Object> getSelfFieldValue(Object self) {
        // <字段名称 ,值>
        Map<String, Object> fieldValueMap = new HashMap<>();
        Field[] declaredFields = self.getClass().getDeclaredFields();
        for (Field field : declaredFields
        ) {
            //设置是否可以访问，如果不设置将报错
            field.setAccessible(true);
            Class<?> filedClassType = field.getType();
            String filedClassName = filedClassType.getName();
            String fieldName = field.getName();
            try {
                // 字段值
                Object fieldVal = field.get(self);
                if (fieldVal != null) {
                    fieldValueMap.put(fieldName, fieldVal);
                }
            } catch (IllegalAccessException e) {
                // 这个异常因为是 private 修饰的 字段
                //  //设置是否可以访问，如果不设置将报错
                //    declaredFields[i].setAccessible(true);
                e.printStackTrace();
            }
        }

//        log.info("自己: {}",obj.toString());
        return fieldValueMap;
    }

    /**
     * self 与 should必须是同一个 class
     *
     * @param self   当 self 里面字段值是空的 null，则使用 should 里面的代替
     * @param should
     * @param <T>
     * @return
     */
    public static <T> T returnSelfAndReplaceSelfFieldIfNull(Object self, Object should) {
        if (self.getClass().equals(should.getClass())) {
            return (T) replaceSelfFieldIfNull(self, should);
        }
        return null;
    }

    /**
     * @param self   如果这里面有字段是 null 则将 should 里面的字段值赋值上去
     * @param should
     * @return
     */
    private static Object replaceSelfFieldIfNull(Object self, Object should) {
        Field[] declaredFields = self.getClass().getDeclaredFields();
        // <字段名称 ,键值对>
        Map<String, Object> fieldValueMap = getSelfFieldValue(should);
        for (Field field : declaredFields
        ) {
            //设置是否可以访问，如果不设置将报错
            field.setAccessible(true);
//            Class<?> filedClassType = field.getType();
//            String filedClassName = filedClassType.getName();
            String fieldName = field.getName();
            try {
                // 字段值
                Object fieldVal = field.get(self);
                if (fieldVal == null) {
                    if (fieldValueMap.get(fieldName) != null) {
                        field.set(self, fieldValueMap.get(fieldName));
                    }
                }
            } catch (IllegalAccessException e) {
                // 这个异常因为是 private 修饰的 字段
                //  //设置是否可以访问，如果不设置将报错
                //    declaredFields[i].setAccessible(true);
                e.printStackTrace();
            }
        }
        return self;
    }

    /**
     * 将自己成员变量是 null 的设置一个初始值
     *
     * @param obj
     * @return
     */
    private static Object initSelfFieldIfNull(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields
        ) {
            //设置是否可以访问，如果不设置将报错
            field.setAccessible(true);
            Class<?> filedClassType = field.getType();
            String filedClassName = filedClassType.getName();
//            String fieldName = field.getName();
            try {
                // 字段值
                Object fieldVal = field.get(obj);
                if (fieldVal == null) {
                    if (filedClassName.equals("java.lang.String")) {
                        field.set(obj, "");
                    } else if (filedClassName.equals("java.util.Date")) {
                        field.set(obj, new Date());
                    } else if (filedClassName.equals("java.lang.Integer")) {
                        field.set(obj, 0);
                    } else if (filedClassName.equals("java.lang.Double")) {
                        field.set(obj, 0D);
                    } else if (filedClassName.equals("java.lang.Float")) {
                        field.set(obj, 0F);
                    } else if (filedClassName.equals("java.lang.Long")) {
                        field.set(obj, 0L);
                    } else if (filedClassName.equals("java.lang.Boolean")) {
                        field.set(obj, false);
                    } else if (filedClassName.equals("java.lang.Short")) {
                        field.set(obj, null);
                    } else if (filedClassName.equals("java.lang.Byte")) {
                        field.set(obj, null);
                    } else if (filedClassName.equals("java.lang.Character")) {
                        field.set(obj, null);
                    } else if (filedClassName.equals("int")) {
                        field.set(obj, 0);
                    } else if (filedClassName.equals("double")) {
                        field.set(obj, 0d);
                    } else if (filedClassName.equals("long")) {
                        field.set(obj, 0L);
                    } else if (filedClassName.equals("boolean")) {
                        field.set(obj, false);
                    } else if (filedClassName.equals("float")) {
                        field.set(obj, 0f);
                    } else if (filedClassName.equals("short")) {
                        field.set(obj, (short) 0);
                    } else if (filedClassName.equals("byte")) {
                        field.set(obj, (byte) 0);
                    } else if (filedClassName.equals("char")) {
                        field.set(obj, null);
                    }
                }
            } catch (IllegalAccessException e) {
                // 这个异常因为是 private 修饰的 字段
                //  //设置是否可以访问，如果不设置将报错
                //    declaredFields[i].setAccessible(true);
                e.printStackTrace();
            }
        }

//        log.info("自己: {}",obj.toString());
        return obj;
    }


    public static <T> T returnEntityAfterValA2ValB(Object valA, Object valB){
        return (T) entityValA2ValB(valA,valB);
    }

    /**
     * 将 实体类 valA 转换成 valB
     *
     * @param valA
     * @param valB
     * @return
     */
    private static Object entityValA2ValB(Object valA, Object valB) {
        Map<String, Object> mapA = getSelfFieldValue(valA);
//        Map<String, Object> mapB = getSelfFieldValue(valB);

//        Class reflectClass = null;
//        try {
//             reflectClass =Class.forName(valB.getClass().getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if (reflectClass == null){
//            return null;
//        }

        Field[] declaredFields =valB.getClass().getDeclaredFields();
        // <字段名称 ,键值对>
        for (Field field : declaredFields
        ) {
            //设置是否可以访问，如果不设置将报错
            field.setAccessible(true);
//            Class<?> filedClassType = field.getType();
//            String filedClassName = filedClassType.getName();
            String fieldName = field.getName();
            try {
                // 字段值
//                Object fieldVal = field.get(valB);
                Object valueA = mapA.get(fieldName);
                if ( valueA != null){
//                    field.set(valB,valueA);
                    field.set(valB,valueA);
                }
            } catch (IllegalAccessException e) {
                // 这个异常因为是 private 修饰的 字段
                //  //设置是否可以访问，如果不设置将报错
                //    declaredFields[i].setAccessible(true);
                e.printStackTrace();
            }
        }
        return valB;
    }


    /**
     * 使用反射的 ，将自己基本类型为空的  或者引用类型为null的  设置一个初始值
     *
     * @param obj
     * @param <T>
     * @return 返回的是 T
     */
    public static <T> T returnSelfAndInitFieldIfNull(Object obj) {
        return (T) initSelfFieldIfNull(obj);
    }


    // 实例化出现异常情况
//   String name = obj.getClass().getName();
//     if (name.equals("java.util.ArrayList")){
//        // 获得给定类的第一个泛型参数
//        Class argType = ClassUtil.getTypeArgument(type);
//        log.info("argType :{}",argType);
//        try {
//            Class<?> clazz = type.getClass().newInstance(); // List 是接口不能实例化 // 出错
//            log.info("clazz.getTypeParameters(): {}",clazz.getTypeParameters());
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }


//    private static <T> T initFieldIfNullTest(Object obj){
//        String name = obj.getClass().getName();
//        log.info("name :{}",name);
//        Class resultClass = null;
//        Object resultObj = null;
//        try {
//            resultClass = Class.forName(name);
//            resultObj = resultClass.newInstance(); //必须实例化对象
//        }catch (Exception e){
//
//        }
//        Field[] declaredFields = obj.getClass().getDeclaredFields();
//        for (int i = 0; i <declaredFields.length ; i++) {
//            Field field = declaredFields[i];
//            //设置是否可以访问，如果不设置将报错
//            field.setAccessible(true);
//            Class<?> type = field.getType();
//            String typeName = type.getName();
//            log.info(" Class<?> type(字段类型) :{},字段类型名称: {}",type,type.getName());
//            String fieldName = field.getName();
//            System.out.println("字段名称："+fieldName);
//            try {
//                Object fieldVal = field.get(obj);
//                System.out.println("字段值："+fieldVal);
//
//                if (fieldVal != null){
//
//                }
//
//                if (fieldVal == null){
//                    if (typeName.equals("java.lang.String")){
//                        // java.lang.IllegalArgumentException: Can not set java.lang.String field com.javabootpro.appModules.user.domain.UserDO.playerId to java.lang.String
//                        field.set(obj,""); // 设置自己 该字段的值
//                        field.set(resultObj,"");
//                    }else if (typeName.equals("java.util.Date")){
//                        field.set(resultObj,new Date());
//                    }
//                }
//            }catch (IllegalAccessException e){
//                // 这个异常因为是 private 修饰的 字段
//                //  //设置是否可以访问，如果不设置将报错
//                //            declaredFields[i].setAccessible(true);
//                e.printStackTrace();
//            }
//
//
//        }
//
////       return (T) obj;r
//        log.info("自己: {}",obj.toString());
//        return (T) resultObj;
//    }


//    private static <T>T getDefault(Class<T> type,Object obj){
//
//        String name = obj.getClass().getName();
//        log.info("name :{}",name);
//        Class result = null;
//        try {
//            result = Class.forName(name);
//        }catch (Exception e){
//
//        }
//
//        //通过反射获取对象的所有字段，是一个数组
//        Field[] declaredFields = obj.getClass().getDeclaredFields();
//        for (int i = 0; i <declaredFields.length ; i++) {
//            //设置是否可以访问，如果不设置将报错
//            declaredFields[i].setAccessible(true);
//            System.out.println("字段："+declaredFields[i]);
//            System.out.println("字段类型："+declaredFields[i].getType());
//            System.out.println("字段名称："+declaredFields[i].getName());
//            try {
//                Object fieldVal = declaredFields[i].get(obj);
//                System.out.println("字段值："+fieldVal);
//            }catch (Exception e){
//
//            }
//        }
//
//        return null;
//
//    }


}
