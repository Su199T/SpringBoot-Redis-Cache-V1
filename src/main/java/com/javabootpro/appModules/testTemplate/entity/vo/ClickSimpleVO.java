package com.javabootpro.appModules.testTemplate.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  客户端传来的 VO
 */

// 注意!!!
// 使用 @RequestBody  注解接收json的时候  必须加上 构造器
// 这里使用 lombok 的注解
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClickSimpleVO {

    private Integer type; // 客户端约定 分类 的类型  不能传 0
    private String gameName;
    private String clickName; // 打点名称
    private String platform; // Platform

}
