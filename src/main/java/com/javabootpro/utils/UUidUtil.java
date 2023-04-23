package com.javabootpro.utils;

import cn.hutool.core.util.IdUtil;

public class UUidUtil {

    public static String getId(){
        return  IdUtil.simpleUUID();
    }
}
